package com.cloud.catalogservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cloud.catalogservice.model.Note;

@Repository
public interface INoteRepository extends JpaRepository<Note, Long> {

}
