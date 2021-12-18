package guru.springFramewrok.spring5webapp.repositories;

import guru.springFramewrok.spring5webapp.domain.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher,Long> {
}
