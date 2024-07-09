package com.sparta.pt.springjpa.services;

import com.sparta.pt.springjpa.entities.AuthorEntity;
import com.sparta.pt.springjpa.repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorService {
    private final AuthorRepository authorRepository;

    @Autowired
    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public List<AuthorEntity> getAllAuthors() {
        return authorRepository.findAll();
    }

    public Optional<AuthorEntity> getAuthorById(int id) {
        return authorRepository.findById(id);
    }

    public AuthorEntity addAuthor(AuthorEntity author) {
        return authorRepository.save(author);
    }

    public void deleteAuthor(int id) {
        authorRepository.deleteById(id);
    }

    public AuthorEntity updateAuthor(AuthorEntity author) {
        return authorRepository.save(author);
    }
}
