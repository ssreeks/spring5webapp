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

        Address publisherAddress1 = new Address("4800 Fredericksburd Rd","San Antonio","Texas","78024");
        Address publisherAddress2 = new Address("1200 Fredericksburd Rd","San Antonio","Texas","78024");
        Publisher publisher = new Publisher("Dc Books", publisherAddress1);

        Author blach = new Author("Blach","ERIC");
        Book effectiveJava = new Book("Effective Java","1212");
        blach.getBooks().add(effectiveJava);
        effectiveJava.getAuthors().add(blach);

        Author ballard = new Author("Moncur","Ballard");
        Book teachYourself  = new Book("Teach Yourself JavaScript","1313");
        ballard.getBooks().add(teachYourself);
        teachYourself.getAuthors().add(ballard);
        authorRepository.save(blach);
        bookRepository.save(effectiveJava);

        authorRepository.save(ballard);
        bookRepository.save(teachYourself);

        publisher.getBooks().add(effectiveJava);
        effectiveJava.setPublisher(publisher);

        publisher.getBooks().add(teachYourself);
        teachYourself.setPublisher(publisher);

        addressRepository.save(publisherAddress1);
        addressRepository.save(publisherAddress2);
        publisherRepository.save(publisher);

        System.out.println("BookRepository Count=" + bookRepository.count());
        System.out.println("Publisher Count="+ publisherRepository.count());
        System.out.println("Address Count="+ addressRepository.count());
        System.out.println(" Published Books="+ publisher.getBooks().size());
        //publisherRepository.findAll().forEach(s->s.toString());
    }
}
