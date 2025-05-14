package exam.project.backend.backend_project_exam.controllers.rest_controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import exam.project.backend.backend_project_exam.models.Game;
import exam.project.backend.backend_project_exam.service.GamesService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;



// !! videogame || videogames
@RestController
@RequestMapping("/api/videogames")
@CrossOrigin(origins = "http://localhost:5173/")
public class GamesRestController {

    @Autowired
    private GamesService gamesService;

    // index
    @GetMapping
    public ResponseEntity<List<Game>> findAll() {

        if (gamesService.findAll().isEmpty()) {
            return new ResponseEntity<List<Game>>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<List<Game>>(gamesService.findAll(), HttpStatus.OK);
    }

    // search
    @GetMapping("/search")
    public ResponseEntity<List<Game>> findByName(@RequestParam String name) {

        if (gamesService.findByNameContainingIgnoreCase(name).isEmpty()) {
            return new ResponseEntity<List<Game>>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<List<Game>>(gamesService.findByNameContainingIgnoreCase(name), HttpStatus.OK);
    }
    

    // show
    @GetMapping("/{id}")
    public ResponseEntity<Game> getMethodName(@PathVariable Integer id) {

        if (gamesService.findById(id).isEmpty()) {
            return new ResponseEntity<Game>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(gamesService.getById(id), HttpStatus.OK);
    }
    
    

    
}
