package guru.springFramewrok.spring5webapp.repositories;

import guru.springFramewrok.spring5webapp.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book,Long> {
}
