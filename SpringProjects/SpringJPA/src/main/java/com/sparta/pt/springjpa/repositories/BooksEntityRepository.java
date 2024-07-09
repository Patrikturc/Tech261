package com.sparta.pt.springjpa.repositories;

import com.sparta.pt.springjpa.entities.BooksEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BooksEntityRepository extends JpaRepository<BooksEntity, Integer> {
}