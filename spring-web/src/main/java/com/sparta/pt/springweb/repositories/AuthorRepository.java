package com.sparta.pt.springweb.repositories;

import com.sparta.pt.springweb.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Integer> {
}