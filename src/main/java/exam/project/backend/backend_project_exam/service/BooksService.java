package exam.project.backend.backend_project_exam.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import exam.project.backend.backend_project_exam.models.Book;
import exam.project.backend.backend_project_exam.repositories.BookRepository;

@Service
public class BooksService {

    @Autowired
    private BookRepository bookRepository;

    // index
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    // search
    public List<Book> findByTitle(String title) {
        return bookRepository.findByTitleContainingIgnoreCase(title);
    }

    // show
    public Optional<Book> findById(Integer id) {
        return bookRepository.findById(id);
    }

    public Book getById(Integer id) {
        return bookRepository.findById(id).get();
    }

    
}
