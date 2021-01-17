package com.apori.commentaireservice.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class CommentaireResponse {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idCommentaire;
	
	private Integer idPublication;
	
	private Integer idUser;
	
	@Size(max = 200)
	private String contenu;
}

