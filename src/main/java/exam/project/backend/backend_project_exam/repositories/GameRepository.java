package exam.project.backend.backend_project_exam.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import exam.project.backend.backend_project_exam.models.Game;

public interface GameRepository extends JpaRepository<Game, Integer> {

    public List<Game> findByNameContainingIgnoreCase(String title);
    
    
}
