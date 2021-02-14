package com.apori.userservice.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.apori.userservice.configuration.AbstractController;
import com.apori.userservice.model.User;
import com.apori.userservice.repository.UserRepository;
import com.apori.userservice.response.model.Publicationresponse;
import com.apori.userservice.service.Userservice;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/user/")
public class UserController extends AbstractController<User> {
	
	@Autowired
	Userservice userservice;
	
	private Logger logger = LogManager.getLogger(UserController.class);
	
	//Retourne tous les utilisateurs 
	@GetMapping(path="/allusers")
	public @ResponseBody List<User> getAllusers(HttpServletRequest resquest, HttpServletResponse response){
		List<User> Userlist = userservice.getUsers();
		return Userlist;
	}
	
	//Retourne les publication d'un utilisateur
	@GetMapping(path = "/{id}/Publications/")
	public @ResponseBody List<Publicationresponse> getUserPublication(HttpServletRequest resquest,@PathVariable Long idUser){
		List<Publicationresponse> UserPublicationList = userservice.getUserPublications(idUser);
		return UserPublicationList;
		
	}
	
	//Retourne un utilisateur au moyen de son id
	@GetMapping(path = "/{idUser}")
	public @ResponseBody ResponseEntity<User> getUserbyID(HttpServletRequest request,HttpServletResponse response,@PathVariable long idUser){
		Optional<User> retrievedUser = userservice.getUserbyID(idUser);
		if(retrievedUser.isPresent()) {
			return new ResponseEntity<User>(getHeaders(),HttpStatus.OK);
		}else {
			return null;
		}
	}
	
	//Retourne un utilisateur au moyen de son nom
	@GetMapping(path = "/{username}")
	public @ResponseBody ResponseEntity<User>  getUserbyName(HttpServletRequest request, HttpServletResponse response,@PathVariable String username){
		Optional<User> retrievedUser = userservice.getUserbyname(username);
		if(retrievedUser.isPresent()) {
			return new ResponseEntity<User>(getHeaders(),HttpStatus.OK);
		}else {
			return null;
		}
	}
	
	
}
