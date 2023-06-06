package com.wiley.bookapp.repository;

import com.wiley.bookapp.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepo extends JpaRepository<Book, String> {
}

