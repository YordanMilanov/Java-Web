package bg.softuni.books.service;

import bg.softuni.books.model.dto.AuthorDTO;
import bg.softuni.books.model.dto.BookDTO;
import bg.softuni.books.model.entity.AuthorEntity;
import bg.softuni.books.model.entity.BookEntity;
import bg.softuni.books.repository.AuthorRepository;
import bg.softuni.books.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public BookService(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    public List<BookDTO> getAllBooks() {
        return bookRepository.findAll()
                .stream()
                .map(this::map).toList();
    }

    private BookDTO map(BookEntity bookEntity){
        AuthorDTO authorDTO = new AuthorDTO();
                authorDTO.setName(bookEntity.getAuthor().getName());
                BookDTO bookDTO = new BookDTO();
                bookDTO.setId(bookEntity.getId());
                bookDTO.setAuthor(authorDTO);
                bookDTO.setIsbn(bookEntity.getIsbn());
                bookDTO.setTitle(bookEntity.getTitle());
        return bookDTO;
    }

    public Optional<BookDTO> findBookById(Long bookId) {
        return bookRepository.findById(bookId).map(this::map);
    }

    public void deleteById(Long bookId) {
        bookRepository.deleteById(bookId);
    }

    public long createBook(BookDTO newBook) {
        String authorName = newBook.getAuthor().getName();
        Optional<AuthorEntity> authorOpt = this.authorRepository
                .findAuthorEntityByName(authorName);

        BookEntity newBookEntity = new BookEntity();
        newBookEntity.setTitle(newBook.getTitle());
        newBookEntity.setIsbn(newBook.getIsbn());
        newBookEntity.setAuthor(authorOpt.orElseGet(() -> createNewAuthor(authorName)));

        return bookRepository.save(newBookEntity).getId();
    }

    private AuthorEntity createNewAuthor(String authorName) {
        AuthorEntity authorEntity = new AuthorEntity();
        authorEntity.setName(authorName);
        return authorRepository.save(authorEntity);
    }
}
