package com.sparta.pt.springweb.controllers;

import com.sparta.pt.springweb.entities.Author;
import com.sparta.pt.springweb.repositories.AuthorRepository;
import jakarta.validation.Valid;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/authors")
public class AuthorsController {

    private final AuthorRepository authorRepository;

    public AuthorsController(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @GetMapping()
    @PreAuthorize("hasRole('ROLE_USER')")
    public String authors(@RequestParam(required = false, defaultValue = "World") String msg, Model model) {
        model.addAttribute("authors", authorRepository.findAll());
        model.addAttribute("msg", msg);
        return "authors/list";
    }

    @GetMapping("/create")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String createAuthor(Model model){
        model.addAttribute("author", new Author());
        return "authors/create";
    }

    @PostMapping("/create")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String createAuthor(@Valid @ModelAttribute("author") Author author, Errors errors){
        if (errors.hasErrors()) {
            return "authors/create";
        }
        authorRepository.save(author);
        return "redirect:/authors";
    }
}
