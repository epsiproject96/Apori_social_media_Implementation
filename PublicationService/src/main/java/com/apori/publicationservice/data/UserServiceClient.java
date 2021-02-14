package com.apori.publicationservice.data;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.apori.publicationservice.response.model.Userresponse;

@FeignClient(name = "UserService")
public interface UserServiceClient {
	
	@GetMapping(path = "/api/user/userByID/{id}")
	public List<Userresponse> getUserByID(@PathVariable Long idUser);

}
