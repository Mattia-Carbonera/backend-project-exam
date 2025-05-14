package exam.project.backend.backend_project_exam.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import exam.project.backend.backend_project_exam.repositories.BookRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;




@Controller
@RequestMapping("/books")
public class BooksController {

    @Autowired
    private BookRepository bookRepository;

    // index
    @GetMapping
    public String index(Model model) {
        model.addAttribute("books", bookRepository.findAll());
        model.addAttribute("page", "books");

        return new String("contentPage");
    }

    // search
    @GetMapping("/search")
    public String search(@RequestParam("title") String title, Model model) {
        model.addAttribute("books", bookRepository.findByTitleContainingIgnoreCase(title));
        model.addAttribute("page", "books");

        return new String("contentPage");
    }
    public String getMethodName(@RequestParam String param) {
        return new String();
    }
    

    // show
    @GetMapping("/{id}")
    public String show(@PathVariable Integer id, Model model) {
        model.addAttribute("item", bookRepository.findById(id).get());
        model.addAttribute("page", "books");

        return new String("showPage");
    }
    
    
    
}
