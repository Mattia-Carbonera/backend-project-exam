package exam.project.backend.backend_project_exam.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import exam.project.backend.backend_project_exam.models.Movie;

public interface MovieRepository extends JpaRepository<Movie, Integer> {

    public List<Movie> findByTitleContainingIgnoreCase(String title);
    
}
