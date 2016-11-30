package com.ljy.weixin.message;

import java.util.List;

public class NewsMessage extends BaseMessage{

	 private int ArticleCount;
	
	 private List<Article> Articles;

	public int getArticleCount() {
		return ArticleCount;
	}

	public void setArticleCount(int articleCount) {
		ArticleCount = articleCount;
	}

	public List<Article> getArticles() {
		return Articles;
	}

	public void setArticles(List<Article> articles) {
		Articles = articles;
	}

	@Override
	public String toString() {
		return "NewsMessage [ArticleCount=" + ArticleCount + ", Articles="
				+ Articles + "]";
	} 
	 
	 
}
