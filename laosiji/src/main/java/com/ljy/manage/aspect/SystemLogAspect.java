package com.ljy.manage.aspect;

import java.lang.reflect.Method;

import javax.annotation.Resource;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.servlet.ShiroHttpServletRequest;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.alibaba.druid.support.http.WebStatFilter;
import com.alibaba.druid.support.http.WebStatFilter.StatHttpServletResponseWrapper;
import com.ljy.common.DateUtil;
import com.ljy.entity.Log;
import com.ljy.entity.User;
import com.ljy.manage.controller.SystemControllerLog;
import com.ljy.manage.controller.base.BaseController;
import com.ljy.manage.service.log.LogService;
import com.ljy.manage.service.systemlog.SystemServiceLog;

/**
 * 切点类
 * 
 * @author LSQ
 * by QQ237442461 2016-10-6
 *
 */
@Aspect    
@Component 
public class SystemLogAspect extends BaseController{
	
	private JSONArray jsonArray;
	
	private JSONObject jsonObject;
	

	@Resource(name = "logService")
	private LogService logService;
	
	//本地异常日志记录对象    
    private  static  final Logger logger = LoggerFactory.getLogger(SystemLogAspect. class);
    
    //Service层切点    
    @Pointcut("@annotation(com.ljy.manage.controller.SystemControllerLog)")    
    public void controllerAspect() {} 
    
    //Service层切点    
    @Pointcut("@annotation(com.ljy.manage.service.systemlog.SystemServiceLog)")    
    public  void serviceAspect() {} 
    
    /**  
     * 前置通知 用于拦截Controller层记录用户的操作  
     *  
     * @param joinPoint 切点  
     * @throws Exception 
     */    
    @Before("controllerAspect()")    
     public  void doBefore(JoinPoint joinPoint) throws Exception {    
    	Subject subject = SecurityUtils.getSubject();
        //请求的IP
         try {
             //*========控制台输出=========*// 
        		if(subject!=null){
	           	 	 User user = (User)subject.getPrincipal();
		           	 Session session = subject.getSession();
		           	 String host = session.getHost();
	           	 	 //获取用户请求方法的参数并序列化为JSON格式字符串    
		             String params = "";    
		             if (joinPoint.getArgs() !=  null && joinPoint.getArgs().length > 0) {  
		                for ( int i = 0; i < joinPoint.getArgs().length; i++) {  
		                	if(joinPoint.getArgs()[i] instanceof StatHttpServletResponseWrapper ||joinPoint.getArgs()[i] instanceof ShiroHttpServletRequest || joinPoint.getArgs()[i] instanceof WebStatFilter){
		                		continue;
		                	}
		                    params += com.alibaba.druid.support.json.JSONUtils.toJSONString(joinPoint.getArgs()[i]) + ";";    
		                }    
		             } 
		           	 if(super.logger.isDebugEnabled()){
		           	 	super.logger.info("");
		            	super.logger.info("=====前置通知开始=====");
		            	super.logger.info("请求方法:" + (joinPoint.getTarget().getClass().getName() + "." + joinPoint.getSignature().getName() + "()"));  
		            	if(user!=null){
		            		super.logger.info("请求人:" + user.getUserName()); 
		            	}
		            	super.logger.info("方法描述:" + getControllerMethodDescription(joinPoint));    
		            	super.logger.info("请求参数:" + params);  
		            	super.logger.info("请求host:" + host);  
		           	 }
           	 	}
        	  
            //*========数据库日志=========*//    
            Log log = new Log();
            log.setTitle(getControllerMethodDescription(joinPoint));
            if(subject!=null){
            	User user = (User) subject.getPrincipal(); 
            	if(user!=null){
            		log.setAddUser(user.getUserName());
            	}
            }
            log.setType(0);
            log.setAddDate(DateUtil.getCurrentDate());
            //保存数据库    
            this.logService.saveSelective(log);
            if(super.logger.isDebugEnabled()){
            	super.logger.info("=====前置通知结束=====");
            }
        }  catch (Exception e) {    
            //记录本地异常日志    
            logger.error("==前置通知异常==");    
            logger.error("异常信息:{}", e.getMessage());
            e.printStackTrace();
        }
       
    }
    /**  
     * 异常通知 用于拦截service层记录异常日志  
     *  
     * @param joinPoint  
     * @param e  
     */    
     @AfterThrowing(pointcut = "serviceAspect()", throwing = "e")    
     public  void doAfterThrowing(JoinPoint joinPoint, Throwable e) {
    	 Subject subject = SecurityUtils.getSubject();
    	 User user = (User) subject.getPrincipal();
    	 Session session = subject.getSession();
       	 String host = session.getHost();
       	 //获取用户请求方法的参数并序列化为JSON格式字符串    
         String params = "";    
         if (joinPoint.getArgs() !=  null && joinPoint.getArgs().length > 0) {  
        	 
            for ( int i = 0; i < joinPoint.getArgs().length; i++) {    
                params += joinPoint.getArgs()[i] + ";";    
            }    
         }
         try {  
        	//*========控制台输出=========*//   
        	 if(super.logger.isDebugEnabled()){
        		super.logger.info("");
             	super.logger.info("=====异常通知开始=====");   
             	super.logger.info("异常代码:" + e.getClass().getName());    
             	super.logger.info("异常信息:" + e.getMessage());   
             	super.logger.info("异常代码:" + e.getClass().getName());    
             	super.logger.info("异常方法:" + (joinPoint.getTarget().getClass().getName() + "." + joinPoint.getSignature().getName() + "()"));    
             	if(user!=null){
             		super.logger.info("请求人:" + user.getUserName()); 
             	}
             	super.logger.info("方法描述:" + getServiceMthodDescription(joinPoint));    
             	super.logger.info("请求host:" + host);
             	super.logger.info("请求参数:" + params);    
        	 }
        	
            /*==========数据库日志=========*/    
            //保存数据库   
            Log log = new Log();
            log.setAddDate(DateUtil.getCurrentDate());
            if(user != null){
            	 log.setAddUser(user.getUserName());
            }
            log.setTitle(getServiceMthodDescription(joinPoint));
            log.setType(1);
            this.logService.saveSelective(log); 
            if(super.logger.isDebugEnabled()){
            	super.logger.info("=====异常通知结束=====");  
            }
        }  catch (Exception ex) {    
            //记录本地异常日志    
            logger.error("==异常通知异常==");    
            logger.error("异常信息:{}", ex.getMessage());    
        }    
         /*==========记录本地异常日志==========*/    
        logger.error("异常方法:{}异常代码:{}异常信息:{}参数:{}", joinPoint.getTarget().getClass().getName() + joinPoint.getSignature().getName(), e.getClass().getName()+params);    
    }    
    
    /**  
     * 获取注解中对方法的描述信息 用于Controller层注解  
     *  
     * @param joinPoint 切点  
     * @return 方法描述  
     * @throws Exception  
     */    
     public  static String getControllerMethodDescription(JoinPoint joinPoint)  throws Exception {    
        String targetName = joinPoint.getTarget().getClass().getName();    
        String methodName = joinPoint.getSignature().getName();    
        Object[] arguments = joinPoint.getArgs();    
        Class targetClass = Class.forName(targetName);    
        Method[] methods = targetClass.getMethods();    
        String description = "";    
         for (Method method : methods) {    
             if (method.getName().equals(methodName)) {    
                Class[] clazzs = method.getParameterTypes();    
                 if (clazzs.length == arguments.length) {    
                    description = method.getAnnotation(SystemControllerLog.class).description();    
                     break;    
                }    
            }    
        }    
         return description;    
    }
     /**  
      * 获取注解中对方法的描述信息 用于service层注解  
      *  
      * @param joinPoint 切点  
      * @return 方法描述  
      * @throws Exception  
      */    
      public  static String getServiceMthodDescription(JoinPoint joinPoint)    
              throws Exception {    
         String targetName = joinPoint.getTarget().getClass().getName();    
         String methodName = joinPoint.getSignature().getName();    
         Object[] arguments = joinPoint.getArgs();    
         Class targetClass = Class.forName(targetName);    
         Method[] methods = targetClass.getMethods();    
         String description = "";    
          for (Method method : methods) {    
              if (method.getName().equals(methodName)) {    
                 Class[] clazzs = method.getParameterTypes();    
                  if (clazzs.length == arguments.length) {    
                     description = method.getAnnotation(SystemServiceLog.class).description();    
                      break;    
                 }    
             }    
         }    
          return description;    
     }    
}
