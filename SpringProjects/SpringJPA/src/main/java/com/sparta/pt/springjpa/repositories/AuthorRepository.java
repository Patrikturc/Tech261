package com.sparta.pt.springjpa.repositories;

import com.sparta.pt.springjpa.entities.AuthorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface AuthorRepository extends JpaRepository<AuthorEntity, Integer> {

    Iterable<AuthorEntity> findByFullName(String name);

    @Transactional
    @Modifying
    void deleteByFullName(String name);

    boolean existsByFullName(String fullName);

    @Transactional
    @Modifying
    @Query("update AuthorEntity a set a.fullName = ?1 where a.id = ?2")
    void updateFullName(String fullName, Integer id);


}
