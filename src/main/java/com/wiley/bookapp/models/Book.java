package com.wiley.bookapp.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "BOOK_TBL")
public class Book {


    @Column(name = "book_id")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long bookId;

    private String bookName;
    private String bookCode;



}
