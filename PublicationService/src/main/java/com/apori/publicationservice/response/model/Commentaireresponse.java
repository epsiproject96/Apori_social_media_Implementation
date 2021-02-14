package com.apori.publicationservice.response.model;

public class Commentaireresponse {
	
	private Integer idCommentaire;
	
	private Integer idPublication;
	
	private Integer idUser;
	
	private String contenu;

	public Integer getIdCommentaire() {
		return idCommentaire;
	}

	public void setIdCommentaire(Integer idCommentaire) {
		this.idCommentaire = idCommentaire;
	}

	public Integer getIdPublication() {
		return idPublication;
	}

	public void setIdPublication(Integer idPublication) {
		this.idPublication = idPublication;
	}

	public Integer getIdUser() {
		return idUser;
	}

	public void setIdUser(Integer idUser) {
		this.idUser = idUser;
	}

	public String getContenu() {
		return contenu;
	}

	public void setContenu(String contenu) {
		this.contenu = contenu;
	}
}
