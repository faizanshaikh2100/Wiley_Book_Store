package com.wiley.bookapp.services;

import com.wiley.bookapp.models.Book;
import com.wiley.bookapp.repository.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    BookRepo bookRepo;

    public void addBook(Book book) {
        bookRepo.save(book);
    }

    public List<Book> getBooks() {
        return bookRepo.findAll();
    }

}
