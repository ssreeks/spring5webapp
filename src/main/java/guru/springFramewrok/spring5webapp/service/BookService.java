package guru.springFramewrok.spring5webapp.service;

import guru.springFramewrok.spring5webapp.domain.Book;
import guru.springFramewrok.spring5webapp.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    private final BookRepository bookRepo;

    @Autowired
    public BookService(BookRepository bookRepo) {
        this.bookRepo = bookRepo;
    }

    public Iterable<Book> getAll() {
        return bookRepo.findAll();
    }
}
