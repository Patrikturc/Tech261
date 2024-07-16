package com.sparta.pt.springrest.repositories;

import com.sparta.pt.springrest.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Integer> {
}