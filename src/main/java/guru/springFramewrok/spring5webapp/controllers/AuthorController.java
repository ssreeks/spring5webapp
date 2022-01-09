package guru.springFramewrok.spring5webapp.controllers;


import guru.springFramewrok.spring5webapp.repositories.AuthorRepository;
import guru.springFramewrok.spring5webapp.service.AuthorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AuthorController {

    AuthorService authorService ;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @RequestMapping(value="/authors", method = RequestMethod.GET)
    public String getAuthors(Model model) {
        model.addAttribute("authors",authorService.getAll());
        return "authors/author_list"  ;
    }
}
