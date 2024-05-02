package kz.runtime.entity;


import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name="books")
public class Books {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="book_name")
    private String name;


    @OneToMany(mappedBy = "books")
    private List<AuthorBooks> author_booksList;


    private LocalDate published;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<AuthorBooks> getAuthor_booksList() {
        return author_booksList;
    }

    public void setAuthor_booksList(List<AuthorBooks> author_booksList) {
        this.author_booksList = author_booksList;
    }

    public LocalDate getPublished() {
        return published;
    }

    public void setPublished(LocalDate published) {
        this.published = published;
    }
}
