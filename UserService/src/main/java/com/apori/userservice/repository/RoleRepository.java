package com.apori.userservice.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apori.userservice.model.ERole;
import com.apori.userservice.model.Role;


@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
	Optional<Role> findByNom(ERole nom);
	
}
