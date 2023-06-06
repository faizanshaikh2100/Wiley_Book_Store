package com.wiley.bookapp.repository;

import com.wiley.bookapp.models.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepo extends JpaRepository<Author, String> {
}
