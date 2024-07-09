package com.sparta.pt.springjpa.controllers;

import com.sparta.pt.springjpa.entities.AuthorEntity;
import com.sparta.pt.springjpa.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/authors")
public class AuthorController {
    private final AuthorService authorService;

    @Autowired
    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping
    public List<AuthorEntity> getAllAuthors() {
        return authorService.getAllAuthors();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AuthorEntity> getAuthorById(@PathVariable int id) {
        return authorService.getAuthorById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public AuthorEntity addAuthor(@RequestBody AuthorEntity author) {
        return authorService.addAuthor(author);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AuthorEntity> updateAuthor(@PathVariable int id, @RequestBody AuthorEntity author) {
        if (!authorService.getAuthorById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        author.setId(id);
        return ResponseEntity.ok(authorService.updateAuthor(author));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAuthor(@PathVariable int id) {
        if (!authorService.getAuthorById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        authorService.deleteAuthor(id);
        return ResponseEntity.noContent().build();
    }
}
