package kz.runtime.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="author")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name="author_name")
    private String name;

    @Column(name="author_lastname")
    private String lastname;

    @OneToMany(mappedBy = "author")
    private List<AuthorBooks> aut_booksList;

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

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public List<AuthorBooks> getAut_booksList() {
        return aut_booksList;
    }

    public void setAut_booksList(List<AuthorBooks> aut_booksList) {
        this.aut_booksList = aut_booksList;
    }
}
