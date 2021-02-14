package com.apori.userservice.response.model;


public class Publicationresponse {
	
	private Integer idPublication;
	private String title;
	private String content;
	private String Image;
	
	public Integer getIdPublication() {
		return idPublication;
	}
	public void setIdPublication(Integer idPublication) {
		this.idPublication = idPublication;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getImage() {
		return Image;
	}
	public void setImage(String image) {
		Image = image;
	}
	
	
}
