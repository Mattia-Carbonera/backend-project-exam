package exam.project.backend.backend_project_exam.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import exam.project.backend.backend_project_exam.models.Song;

public interface SongRepository extends JpaRepository<Song, Integer> {

    public List<Song> findByNameContainingIgnoreCase(String title);
    
}
