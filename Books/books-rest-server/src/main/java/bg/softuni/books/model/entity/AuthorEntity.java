package bg.softuni.books.model.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "authors")
public class AuthorEntity extends BaseEntity{



    private String name;

    @OneToMany(mappedBy = "author")
    private List<BookEntity> books;

    public AuthorEntity() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<BookEntity> getBooks() {
        return books;
    }

    public void setBooks(List<BookEntity> books) {
        this.books = books;
    }

}
