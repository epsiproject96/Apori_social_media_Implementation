package com.apori.publicationservice.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.apori.publicationservice.model.Publication;

@Repository
public interface PublicationDAO extends JpaRepository<Publication, Integer> {

}
