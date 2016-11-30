package com.ljy.common;
/**
 * 各类路径获取的工具类
 * @author mg by qq:349070443
 *
 */
public class PathUtil {
/**
   * @param args
   */
public static void main(String[] args)throws Exception {
   PathUtil p = new PathUtil();
   System.out.println(p.getWebClassesPath());
   System.out.println(p.getWebInfPath());
   System.out.println(p.getWebRoot());
}

public static PathUtil getNewInterface(){
	return new PathUtil();
}
public String getWebClassesPath() {
   String path = getClass().getProtectionDomain().getCodeSource()
     .getLocation().getPath();
   return path;
  
}
 
public String getWebInfPath() throws IllegalAccessException{
   String path = getWebClassesPath();
   if (path.indexOf("WEB-INF") > 0) {
    path = path.substring(0, path.indexOf("WEB-INF")+8);
   } else {
    throw new IllegalAccessException("路径获取错误");
   }
   return path;
}

public String getWebRoot() throws IllegalAccessException{
   String path = getWebClassesPath();
   if (path.indexOf("WEB-INF") > 0) {
    path = path.substring(0, path.indexOf("WEB-INF/classes"));
   } else {
    throw new IllegalAccessException("路径获取错误");
   }
   return path;
}
}