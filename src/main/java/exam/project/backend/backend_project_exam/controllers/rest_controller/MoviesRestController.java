package exam.project.backend.backend_project_exam.controllers.rest_controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import exam.project.backend.backend_project_exam.models.Movie;
import exam.project.backend.backend_project_exam.service.MoviesService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("/api/movies")
@CrossOrigin(origins = "http://localhost:5173/")
public class MoviesRestController {

    @Autowired
    private MoviesService moviesService;

    // index
    @GetMapping
    public ResponseEntity<List<Movie>> index() {

        if (moviesService.findAll().isEmpty()) {
            return new ResponseEntity<List<Movie>>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<List<Movie>>(moviesService.findAll(), HttpStatus.OK);
    }

    // seacrh
    @GetMapping("/search")
    public ResponseEntity<List<Movie>> findByTitle(@RequestParam("title") String title) {

        if (moviesService.findByTitleContainingIgnoreCase(title).isEmpty()) {
            return new ResponseEntity<List<Movie>>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<List<Movie>>(moviesService.findByTitleContainingIgnoreCase(title), HttpStatus.OK);
    }
    

    // show
    @GetMapping("/{id}")
    public ResponseEntity<Movie> show(@PathVariable Integer id) {

        if (moviesService.findById(id).isEmpty()) {
            return new ResponseEntity<Movie>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<Movie>(moviesService.getById(id), HttpStatus.OK);
    }
    
    
    
}
