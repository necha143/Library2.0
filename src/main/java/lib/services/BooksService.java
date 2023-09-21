package lib.services;

import lib.models.Book;
import lib.models.Person;
import lib.repositories.BooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.beans.Transient;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class BooksService {
    private final BooksRepository booksRepository;

    @Autowired
    public BooksService(BooksRepository booksRepository) {
        this.booksRepository = booksRepository;
    }

    public List<Book> findAll(String sort) {
        if (sort == null) {
            return booksRepository.findAll();
        } else {
            return booksRepository.findAll(Sort.by("year"));
        }
    }

    public Book findOne(int id) {
        Optional<Book> foundPerson = booksRepository.findById(id);
        return foundPerson.orElse(null);
    }

    @Transactional
    public void save(Book book) {
        booksRepository.save(book);
    }

    @Transactional
    public void update(int id, Book updatedBook) {
        updatedBook.setBookID(id);
        booksRepository.save(updatedBook);
    }

    @Transactional
    public void delete(int id) {
        booksRepository.deleteById(id);
    }

    public Person getBookOwner(int id) {
        // Здесь Hibernate.initialize() не нужен, так как владелец (сторона One) загружается не лениво
        return booksRepository.findById(id).map(Book::getOwner).orElse(null);
    }

    @Transactional
    public void assign(int id, Person selectedPerson) {
        booksRepository.findById(id).ifPresent(
                book -> {
                    book.setTakedAt(new Date());
                    book.setOwner(selectedPerson);
                }
        );
    }

    @Transactional
    public void release(int id) {
        booksRepository.findById(id).ifPresent(
                book -> {
                    book.setOwner(null);
                    book.setTakedAt(null);
                });
    }

    public List<Book> pagination(int page, int booksPerPage, boolean sort) {
        if (!sort) {
            return booksRepository.findAll(PageRequest.of(page, booksPerPage)).getContent();
        } else {
            return booksRepository.findAll(PageRequest.of(page, booksPerPage, Sort.by("year"))).getContent();
        }
    }

    public List<Book> search(String query) {
        return booksRepository.findByNameStartingWith(query);
    }
}
