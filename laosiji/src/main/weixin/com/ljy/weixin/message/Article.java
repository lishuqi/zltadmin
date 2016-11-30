package com.ljy.weixin.message;

public class Article {
	 private String Title; 
	 private String Description; 
	 private String PicUrl; 	
	 private String Url;
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	public String getPicUrl() {
		return PicUrl;
	}
	public void setPicUrl(String picUrl) {
		PicUrl = picUrl;
	}
	public String getUrl() {
		return Url;
	}
	public void setUrl(String url) {
		Url = url;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	@Override
	public String toString() {
		return "Article [Description=" + Description + ", PicUrl=" + PicUrl
				+ ", Title=" + Title + ", Url=" + Url + "]";
	} 
	 
	 
}
