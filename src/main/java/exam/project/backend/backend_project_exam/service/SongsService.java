package exam.project.backend.backend_project_exam.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import exam.project.backend.backend_project_exam.models.Song;
import exam.project.backend.backend_project_exam.repositories.SongRepository;

@Service
public class SongsService {

    @Autowired
    private SongRepository songRepository;

    // index
    public List<Song> findAll() {
        return songRepository.findAll();
    }

    // search
    public List<Song> findByNameContainingIgnoreCase(String name) {
        return songRepository.findByNameContainingIgnoreCase(name);
    }

    // show
    public Optional<Song> findById(Integer id) {
        return songRepository.findById(id);
    }

    public Song getById(Integer id) {
        return songRepository.findById(id).get();
    }

    
}
