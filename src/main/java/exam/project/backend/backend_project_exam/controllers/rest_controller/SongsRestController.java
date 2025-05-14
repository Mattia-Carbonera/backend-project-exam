package exam.project.backend.backend_project_exam.controllers.rest_controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import exam.project.backend.backend_project_exam.models.Song;
import exam.project.backend.backend_project_exam.service.SongsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("/api/songs")
@CrossOrigin(origins = "http://localhost:5173/")
public class SongsRestController {

    @Autowired
    private SongsService songsService;

    // index
    @GetMapping
    public ResponseEntity<List<Song>> findAll() {

        if (songsService.findAll().isEmpty()) {
            return new ResponseEntity<List<Song>>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<List<Song>>(songsService.findAll(), HttpStatus.OK);
    }

    // search
    @GetMapping("/search")
    public ResponseEntity<List<Song>> findByName(@RequestParam("name") String name) {

        if (songsService.findByNameContainingIgnoreCase(name).isEmpty()) {
            return new ResponseEntity<List<Song>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Song>>(songsService.findByNameContainingIgnoreCase(name), HttpStatus.OK);
    }
    

    //show
    @GetMapping("/{id}")
    public ResponseEntity<Song> getById(@PathVariable Integer id) {

        if (songsService.findById(id).isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<Song>(songsService.getById(id), HttpStatus.OK);
    }
    
    
    
    
}
