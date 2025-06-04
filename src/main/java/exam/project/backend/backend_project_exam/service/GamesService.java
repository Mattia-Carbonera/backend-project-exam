package exam.project.backend.backend_project_exam.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import exam.project.backend.backend_project_exam.models.Game;
import exam.project.backend.backend_project_exam.repositories.GameRepository;

@Service
public class GamesService {

    @Autowired
    private GameRepository gameRepository;

    // index
    public List<Game> findAll() {
        return gameRepository.findAll();
    }

    // serach
    public List<Game> findByName(String name) {
        return gameRepository.findByNameContainingIgnoreCase(name);
    }

    // show
    public Optional<Game> findById(Integer id) {
        return gameRepository.findById(id);
    }

    public Game getById(Integer id) {
        return gameRepository.findById(id).get();
    }
    
}
