package com.wiley.bookapp.services;

import com.wiley.bookapp.models.Author;
import com.wiley.bookapp.repository.AuthorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class AuthorService {

    @Autowired
    AuthorRepo authorRepo;

    public void addAuthor(Author author) {
        authorRepo.save(author);
    }

    public List<Author> getAuthors() {
        return authorRepo.findAll();
    }

}
