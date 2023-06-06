package com.wiley.bookapp.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import java.util.Set;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "AUTHOR_TBL")
public class Author {

    @Column(name = "author_id")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long authorId;
    @Column(name = "author_name")
    private String authorName;
    @Column(name = "author_code")
    private String authorCode;


    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "AUTHOR_BOOK_TABLE",
            joinColumns = @JoinColumn(name = "author_id", referencedColumnName = "author_id"),
            inverseJoinColumns = {
                    @JoinColumn(name = "book_id", referencedColumnName = "book_id")
            }
    )

    @JsonManagedReference
    private Set<Book> books;
}
