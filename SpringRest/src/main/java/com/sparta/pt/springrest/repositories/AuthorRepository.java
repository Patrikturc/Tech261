package com.sparta.pt.springrest.repositories;

import com.sparta.pt.springrest.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Integer> {
}