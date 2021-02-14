package com.apori.userservice.data;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.apori.userservice.response.model.Publicationresponse;

@FeignClient(name = "PublicationService")
public interface PublicationServiceClient {

	@GetMapping(path = "/User/{idUser}/Publications/")
	public List<Publicationresponse> getPublications(@PathVariable Long idUser);
	
}
