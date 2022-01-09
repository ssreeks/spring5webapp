package guru.springFramewrok.spring5webapp.service;

import guru.springFramewrok.spring5webapp.domain.Author;
import guru.springFramewrok.spring5webapp.repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {

    private final AuthorRepository authorRepo;

    @Autowired
    public AuthorService(AuthorRepository authorRepo) {
        this.authorRepo = authorRepo;
    }

    public Iterable<Author> getAll() {
        return authorRepo.findAll();
    }
}
