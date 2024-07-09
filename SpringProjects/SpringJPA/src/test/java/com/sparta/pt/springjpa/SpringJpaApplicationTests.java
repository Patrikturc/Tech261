package com.sparta.pt.springjpa;

import com.sparta.pt.springjpa.entities.AuthorEntity;
import com.sparta.pt.springjpa.entities.BooksEntity;
import com.sparta.pt.springjpa.repositories.AuthorRepository;
import com.sparta.pt.springjpa.repositories.BooksEntityRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SpringJpaApplicationTests {

    @Autowired
    private AuthorRepository authorRepository;
    @Autowired
    private BooksEntityRepository booksEntityRepository;

    @Test
    void checkThatICanSeeAllAuthors() {
        List<AuthorEntity> author = authorRepository.findAll();
        assertEquals(3, author.size(), "There should be 3 authors");
    }

    @Test
    void checkThatCreateAuthorWorks() {
        authorRepository.save(new AuthorEntity().setFullName("Fred"));
        assertNotNull(authorRepository.findByFullName("Fred"), "Author should be found");
    }

    @Test
    void checkThatSearchingAuthorByNameWorks() {
        boolean exists = true;
        assertEquals(exists, authorRepository.existsByFullName("Fred"), "Author should be found");
    }

    @Test
    void checkThatDeleteAuthorByNameWorks() {
        authorRepository.deleteByFullName("Fred");
        assertFalse(authorRepository.existsByFullName("Fred"), "Author should not be found");
    }

    @Test
    void checkThatUpdateAuthorNameWorks() {
        boolean exists = true;
        authorRepository.updateFullName("Josh", 21);
        assertEquals(exists, authorRepository.existsByFullName("Josh"), "Josh should be found");
    }

    @Test
    void checkThatICanSeeAllBooks() {
        List<BooksEntity> books = booksEntityRepository.findAll();
        assertEquals(3, books.size(), "There should be 3 books in the database");
        assertTrue(books.stream().anyMatch(book -> book.getTitle().equals("Coding With Java and Spring!")));
        assertTrue(books.stream().anyMatch(book -> book.getTitle().equals("Coding With Spring")));
    }

    @Test
    void checkThatCreateBookWorks() {
        AuthorEntity author = authorRepository.findById(19).orElse(null);
        booksEntityRepository.save(new BooksEntity("CRUD Stuff", author));
        assertTrue(booksEntityRepository.existsByTitle("CRUD Stuff"), "Book should be found");
    }

    @Test
    void checkThatSearchingBooksByTitleWorks() {
        boolean exists = true;
        assertEquals(exists, booksEntityRepository.existsByTitle("Coding With Spring"), "Book should be found");
    }

    @Test
    void checkThatDeleteBookByTitleWorks() {
        booksEntityRepository.deleteByTitle("CRUD Stuff");
        assertFalse(booksEntityRepository.existsByTitle("CRUD Stuff"), "Book should not be found");
    }

    @Test
    void checkThatUpdateBookTittleWorks() {
        boolean exists = true;
        booksEntityRepository.updateByTitle("Coding With Java and Spring!", 2);
        assertEquals(exists, booksEntityRepository.existsByTitle("Coding With Java and Spring!"), "Coding With Java and Spring! should be found");
    }
}
