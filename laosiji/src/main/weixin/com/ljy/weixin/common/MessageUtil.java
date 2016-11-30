package com.ljy.weixin.common;

import java.io.InputStream;
import java.io.Writer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.ljy.weixin.message.Article;
import com.ljy.weixin.message.NewsMessage;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.core.util.QuickWriter;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.io.xml.PrettyPrintWriter;
import com.thoughtworks.xstream.io.xml.XppDriver;

public class MessageUtil {

	 public static final String EVENT_TYPE_SUBSCRIBE = "subscribe"; 
	 
	 public static final String REQ_MESSAGE_TYPE_EVENT = "event"; 
	 
	 public static final String RESP_MESSAGE_TYPE_NEWS = "news"; 
	/** 
	 * 解析微信发来的请求（XML） 
	 *  
	 * @param request 
	 * @return 
	 * @throws Exception 
	 */  
	@SuppressWarnings("unchecked")  
	public static Map parseXml(HttpServletRequest request) throws Exception {  
	    // 将解析结果存储在HashMap中  
	    Map map = new HashMap();  
	  
	    // 从request中取得输入流  
	    InputStream inputStream = request.getInputStream();  
	    // 读取输入流  
	    SAXReader reader = new SAXReader();  
	    Document document = reader.read(inputStream);  
	    // 得到xml根元素  
	    Element root = document.getRootElement();  
	    // 得到根元素的所有子节点  
	    List<Element> elementList = root.elements();  
	    // 遍历所有子节点  
	    for (Element e : elementList)  
	        map.put(e.getName(), e.getText());  
	  
	    // 释放资源  
	    inputStream.close();  
	    inputStream = null;  
	  
	    return map;  
	}
	
	
	  
	  
	/** 
	 * 图文消息对象转换成xml 
	 *  
	 * @param newsMessage 图文消息对象 
	 * @return xml 
	 */  
	public static String newsMessageToXml(NewsMessage newsMessage) {  
	    xstream.alias("xml", newsMessage.getClass());  
	    xstream.alias("item", new Article().getClass());  
	    return xstream.toXML(newsMessage);  
	}  
	  
	/** 
	 * 扩展xstream，使其支持CDATA块 
	 *  
	 * @date 2013-05-19 
	 */  
	private static XStream xstream = new XStream(new XppDriver() {  
	    public HierarchicalStreamWriter createWriter(Writer out) {  
	        return new PrettyPrintWriter(out) {  
	            // 对所有xml节点的转换都增加CDATA标记  
	            boolean cdata = true;  
	  
	            @SuppressWarnings("unchecked")  
	            public void startNode(String name, Class clazz) {  
	                super.startNode(name, clazz);  
	            }  
	  
	            protected void writeText(QuickWriter writer, String text) {  
	                if (cdata) {  
	                	 writer.write("<![CDATA["); 
	                	 writer.write(text); 
	                	 writer.write("]]>"); 
	                } else {  
	                    writer.write(text);  
	                }  
	            }  
	        };  
	    }  
	});  
}
