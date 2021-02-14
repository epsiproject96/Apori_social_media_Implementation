package com.apori.publicationservice.data;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.apori.publicationservice.response.model.Commentaireresponse;

@FeignClient(name = "CommentaireService")
public interface CommentaireServiceClient {
	
	@GetMapping(path = "/Publications/{idPublication}/Commentaires")
	public List<Commentaireresponse> getCommentaires(@PathVariable Long idPublication);
}
