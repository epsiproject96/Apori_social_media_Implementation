package com.apori.publicationservice.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.apori.publicationservice.model.Publication;

@Repository
public interface PublicationDAO extends CrudRepository<Publication, Integer> {

}
