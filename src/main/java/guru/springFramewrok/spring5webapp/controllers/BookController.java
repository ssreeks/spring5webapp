package guru.springFramewrok.spring5webapp.controllers;

import guru.springFramewrok.spring5webapp.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }


    @RequestMapping("/books")
    public String getBooks(Model model) {

        model.addAttribute("books",bookService.getAll());
        return "books/list"  ;
    }
}
