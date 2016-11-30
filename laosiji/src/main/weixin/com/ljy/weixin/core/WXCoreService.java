package com.ljy.weixin.core;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.ljy.weixin.common.MessageUtil;
import com.ljy.weixin.message.Article;
import com.ljy.weixin.message.NewsMessage;

/**
 * 微信核心消息推送service
 * @author sq
 *
 */
public class WXCoreService {
	
	@SuppressWarnings("unchecked")
	public static String processRequest(HttpServletRequest request) throws Exception {
		
		String respMessage = null; 
		
		// 默认返回的文本消息内容 26. 
		String respContent = "请求处理异常，请稍候尝试！";
		
		// xml 请求解析 
		 Map<String, String> requestMap = MessageUtil.parseXml(request);
		// 发送方帐号（open_id）	
		 String fromUserName = requestMap.get("FromUserName"); 	
		// 公众帐号
		 String toUserName = requestMap.get("ToUserName"); 
		 // 消息类型 
		 String msgType = requestMap.get("MsgType"); 
		 	
		 
// 事件推送 
if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_EVENT)) {
	 // 事件类型
	 String eventType = requestMap.get("Event");
	 // 订阅
	 if (eventType.equals(MessageUtil.EVENT_TYPE_SUBSCRIBE)) {
		 respContent = "谢谢您的关注！";
		 
		 NewsMessage newsMessage = new NewsMessage();
		 newsMessage.setToUserName(fromUserName);
		 newsMessage.setFromUserName(toUserName);
		 newsMessage.setCreateTime(new Date().getTime());
		 newsMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_NEWS);

		 newsMessage.setFuncFlag(0); 
		 List<Article> articleList = new ArrayList<Article>(); 
		 Article article = new Article(); 
		 article.setTitle("立简易团队减肥产品介绍");
		 article.setDescription("减肥产品，即具有减肥作用产品。随着审美观念的改变，衍生出来的一种能够使女性达到瘦身目的的产品，因其快速的减肥效果深受女性喜爱。"); 
		 article.setPicUrl("http://bb2c0400.ngrok.io/images/1.jpg");
		 article.setUrl("http://baike.baidu.com/link?url=upj3sQlegCfIGNgm0piDl4-iIjjv4Gw-y63Ead0DovZWdsEOyrLu69qy5rQ_YzmS1exTYJzTj_sXgNguKNiyZ_");
		 articleList.add(article); 
		 newsMessage.setArticleCount(articleList.size());
		 newsMessage.setArticles(articleList); 
		 System.out.println(newsMessage.toString());
		 respMessage = MessageUtil.newsMessageToXml(newsMessage);
		 System.out.println(respMessage.toString());

	 } 
	}
//textMessage.setContent(respContent);
//respMessage = MessageUtil.textMessageToXml(textMessage); 
return respMessage; 
}
}
