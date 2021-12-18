package guru.springFramewrok.spring5webapp.repositories;

import guru.springFramewrok.spring5webapp.domain.Address;
import org.springframework.data.repository.CrudRepository;

public interface AddressRepository extends CrudRepository<Address,Long> {
}
