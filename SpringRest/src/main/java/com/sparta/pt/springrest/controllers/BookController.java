package com.sparta.pt.springrest.controllers;

import com.sparta.pt.springrest.entities.Book;
import com.sparta.pt.springrest.exceptions.IAmATeapotException;
import com.sparta.pt.springrest.exceptions.ResourceNotFoundException;
import com.sparta.pt.springrest.repositories.AuthorRepository;
import com.sparta.pt.springrest.repositories.BookRepository;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("/api/books")
public class BookController {
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public BookController(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    @GetMapping()
    public List<Book> getBooks() {
        return bookRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Book> getBookById(@PathVariable Integer id) {
        if (!bookRepository.existsById(id)) {
            throw new IAmATeapotException("Book with Id " + id + " not found and also, I am a teapot.");
        }
        return bookRepository.findById(id);
    }
    
    @PostMapping
    public ResponseEntity<Book> addBook(@RequestBody Book book, HttpServletRequest request) {
        if (book.getAuthor().getId() == null) {
            authorRepository.save(book.getAuthor());
        } else if (!authorRepository.existsById(book.getAuthor().getId())) {
            throw new ResourceNotFoundException("Author with id " + book.getAuthor().getId() + "not found");
        }

        bookRepository.save(book);

        URI location = URI.create(request.getRequestURL().toString() + "/" + book.getId());
        return ResponseEntity.created(location).body(book);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable Integer id, @RequestBody Book book) {

        if (!Objects.equals(id, book.getId())) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        Optional<Book> authorOptional = bookRepository.findById(id);
        if (authorOptional.isPresent()) {
            book.setId(id);
            bookRepository.save(book);
            return ResponseEntity.ok(book);
        }
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Book> deleteBook(@PathVariable Integer id) {
        Optional<Book> bookOptional = bookRepository.findById(id);

        if (bookOptional.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        bookRepository.delete(bookOptional.get());
        return ResponseEntity.noContent().build();
    }
}
