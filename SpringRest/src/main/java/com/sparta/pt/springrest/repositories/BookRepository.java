package com.sparta.pt.springrest.repositories;

import com.sparta.pt.springrest.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Integer> {
    List<Book> findByAuthorId(Integer id);
}