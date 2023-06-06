package com.wiley.bookapp.controllers;

import com.wiley.bookapp.models.Author;
import com.wiley.bookapp.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthorController {

    @Autowired
    AuthorService authorService;

    @PostMapping("/addAuthor")
    public void createAuthor(@RequestBody Author author) {
        authorService.addAuthor(author);
    }

    @GetMapping("/getAuthors")
    public void getListOfAuthors() {
        authorService.getAuthors();
    }

}
