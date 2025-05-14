package exam.project.backend.backend_project_exam.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import exam.project.backend.backend_project_exam.models.Movie;
import exam.project.backend.backend_project_exam.repositories.MovieRepository;

@Service
public class MoviesService {
    
    @Autowired
    private MovieRepository movieRepository;

    // index
    public List<Movie> findAll() {
        return movieRepository.findAll();
    }

    // search
    public List<Movie> findByTitleContainingIgnoreCase(String name) {
        return movieRepository.findByTitleContainingIgnoreCase(name);
    }

    // show
    public Optional<Movie> findById(Integer id) {
        return movieRepository.findById(id);
    }

    public Movie getById(Integer id) {
        return movieRepository.findById(id).get();
    }

    
}
