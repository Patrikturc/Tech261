package com.sparta.pt.springrest.controllers;

import com.sparta.pt.springrest.entities.Author;
import com.sparta.pt.springrest.repositories.AuthorRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("/api/authors")
public class AuthorController {

    private final AuthorRepository authorRepository;

    public AuthorController(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @GetMapping()
    public List<Author> getAuthors() {
        return authorRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Author> findById(@PathVariable Integer id){
        Author author = authorRepository.findById(id).orElse(null);

        if (author == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(author, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Author> addAuthor(@RequestBody Author author, HttpServletRequest request){
        authorRepository.save(author);

        URI location = URI.create(request.getRequestURL().toString() + "/" + author.getId());
        return ResponseEntity.created(location).body(author);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Author> updateAuthor(@PathVariable Integer id, @RequestBody Author author) {

        if (!Objects.equals(id, author.getId())) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        Optional<Author> authorOptional = authorRepository.findById(id);
        if (authorOptional.isPresent()) {
            author.setId(id);
            authorRepository.save(author);
            return ResponseEntity.ok(author);
        }
        return ResponseEntity.noContent().build();
    }
}
