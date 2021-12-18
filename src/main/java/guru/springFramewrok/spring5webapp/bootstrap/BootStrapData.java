package guru.springFramewrok.spring5webapp.bootstrap;

import guru.springFramewrok.spring5webapp.domain.Address;
import guru.springFramewrok.spring5webapp.domain.Author;
import guru.springFramewrok.spring5webapp.domain.Book;
import guru.springFramewrok.spring5webapp.domain.Publisher;
import guru.springFramewrok.spring5webapp.repositories.AddressRepository;
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
    private final AddressRepository addressRepository;

    @Autowired
    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository,
                         PublisherRepository publisherRepository, AddressRepository addressRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
        this.addressRepository = addressRepository;
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

        Address publisherAddress1 = new Address("4800 Fredericksburd Rd","San Antonio","Texas","78024");
        Address publisherAddress2 = new Address("1200 Fredericksburd Rd","San Antonio","Texas","78024");
        Publisher publisher = new Publisher("Dc Books", publisherAddress1);
        publisher.getBooks().add(teachYourself);


        addressRepository.save(publisherAddress1);
        addressRepository.save(publisherAddress2);
        publisherRepository.save(publisher);

        System.out.println("Publisher Count="+ publisherRepository.count());
        System.out.println("Address Count="+ addressRepository.count());
        //publisherRepository.findAll().forEach(s->s.toString());

    }
}
