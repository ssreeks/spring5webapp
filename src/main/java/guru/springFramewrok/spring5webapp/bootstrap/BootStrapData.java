package guru.springFramewrok.spring5webapp.bootstrap;

import guru.springFramewrok.spring5webapp.domain.Address;
import guru.springFramewrok.spring5webapp.domain.Author;
import guru.springFramewrok.spring5webapp.domain.Book;
import guru.springFramewrok.spring5webapp.domain.Publisher;
import guru.springFramewrok.spring5webapp.repositories.AuthorRepository;
import guru.springFramewrok.spring5webapp.repositories.BookRepository;
import guru.springFramewrok.spring5webapp.repositories.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.sql.SQLOutput;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    @Autowired
    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author blach = new Author("Blach","ERIC");
        Book effectiveJava = new Book("Effective Java","1212");
        blach.getBooks().add(effectiveJava);
        effectiveJava.getAuthors().add(blach);


        authorRepository.save(blach);
        bookRepository.save(effectiveJava);

        Author pearson = new Author("Moncur","Ballard");
        Book teachYourself  = new Book("Teach Yourself JavaScript","1313");
        pearson.getBooks().add(teachYourself);
        teachYourself.getAuthors().add(pearson);


        authorRepository.save(pearson);
        bookRepository.save(teachYourself);
        System.out.println("BookRepository Count=" + bookRepository.count());

        Address publisherAddress = new Address("4800 Fredericksburd Rd","San Antonio","Texas","78024");
        Publisher publisher = new Publisher("Dc Books", publisherAddress);
        publisherRepository.save(publisher);

        System.out.println("Publisher Count="+publisherRepository.count());
    }
}
