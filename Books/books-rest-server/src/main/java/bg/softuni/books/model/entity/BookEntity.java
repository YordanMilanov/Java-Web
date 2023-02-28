package bg.softuni.books.model.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "books")
public class BookEntity extends BaseEntity{


    private String title;
    private String isbn;

    @ManyToOne
    private AuthorEntity author;

    public BookEntity() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public AuthorEntity getAuthor() {
        return author;
    }

    public void setAuthor(AuthorEntity author) {
        this.author = author;
    }

}
