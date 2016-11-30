package com.ljy.manage.quartz;

import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.quartz.QuartzJobBean;

import com.ljy.manage.service.log.LogService;

public class LogJob extends QuartzJobBean{

	@Override
	protected void executeInternal(JobExecutionContext context)
			throws JobExecutionException {
		//获取自己定义的日志jobDetail、的spring容器
		ApplicationContext applicationContext = (ApplicationContext) context.getJobDetail().getJobDataMap().get("applicationContextLog");
		
		//获取需要处理的bean
		LogService logService = (LogService) applicationContext.getBean("logService");
		try {
			System.out.println("定时任务删除所有的日志！~");
			logService.deleteAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
