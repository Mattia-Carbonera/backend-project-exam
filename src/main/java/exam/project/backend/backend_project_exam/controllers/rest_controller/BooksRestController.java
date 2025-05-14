package exam.project.backend.backend_project_exam.controllers.rest_controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import exam.project.backend.backend_project_exam.models.Book;
import exam.project.backend.backend_project_exam.repositories.BookRepository;
import exam.project.backend.backend_project_exam.service.BooksService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("/api/books")
@CrossOrigin(origins = "http://localhost:5173/")
public class BooksRestController {

    private final BookRepository bookRepository;

    @Autowired
    private BooksService booksService;

    BooksRestController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    //index
    @GetMapping
    public ResponseEntity<List<Book>> findAll() {

        if (booksService.findAll().isEmpty()) {
            return new ResponseEntity<List<Book>>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<List<Book>>(bookRepository.findAll(), HttpStatus.OK);
    }

    // show
    @GetMapping("/search")
    public ResponseEntity<List<Book>> search(@RequestParam("title") String title) {

        if (booksService.findByTitle(title).isEmpty()) {
            return new ResponseEntity<List<Book>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Book>>(booksService.findByTitle(title), HttpStatus.OK);
    }
    

    // show
    @GetMapping("/{id}")
    public ResponseEntity<Book> getById(@PathVariable Integer id) {

        if (bookRepository.findById(id).isEmpty()) {
            return new ResponseEntity<Book>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<Book>(booksService.getById(id), HttpStatus.OK);
    }
    
    
    
}
