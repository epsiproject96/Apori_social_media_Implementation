package com.apori.publicationservice.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Publication {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idPublication;
	
	@Size(max =120)
	private String title;
	
	@Size(max =120)
	private String content;
	
	private String Image;
}
