package com.sparta.pt.springjpa.repositories;

import com.sparta.pt.springjpa.entities.BooksEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface BooksEntityRepository extends JpaRepository<BooksEntity, Integer> {
    boolean existsByTitle(String title);

    @Transactional
    @Modifying
    @Query("delete from BooksEntity b where upper(b.title) = upper(?1)")
    void deleteByTitle(String title);

}