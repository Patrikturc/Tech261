package com.sparta.pt.springjpa;

import com.sparta.pt.springjpa.entities.AuthorEntity;
import com.sparta.pt.springjpa.repositories.AuthorRepository;
import com.sparta.pt.springjpa.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.logging.Logger;

@SpringBootApplication //Meta Anotation
public class SpringJpaApplication {

    private static final Logger logger = Logger.getLogger(SpringJpaApplication.class.getName());

    public static void main(String[] args) {
        SpringApplication.run(SpringJpaApplication.class, args);
    }

    //bean -> AuthorRepository -> Class / Command line runner -> Class / AuthorRepository -> object of both -> runner
    @Bean //represents an object that Spring will create
    public CommandLineRunner runner(AuthorRepository repository) {

//        Create, read, update, delete
//        CREATE METHODS
//        repository.save(new AuthorEntity().setFullName("Fred"));
//        DELETE METHODS
//        repository.deleteById(3);
//        repository.deleteAll(repository.findByFullName("Bob"));
//        READ METHODS
//        logger.info(String.valueOf(repository.existsByFullName("Fred")));
//        logger.info(repository.findById(21).orElseThrow().toString());
        return args -> {
            //repository.deleteByFullName("Fred");
            //logger.info(repository.findAll().toString());
            logger.info(String.valueOf(repository.existsByFullName("Fred")));
            logger.info(repository.findById(21).orElseThrow().toString());
        };
    }
}
