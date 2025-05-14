package exam.project.backend.backend_project_exam.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import exam.project.backend.backend_project_exam.repositories.SongRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;




@Controller
@RequestMapping("/songs")
public class SongsControler {

    @Autowired
    private SongRepository songRepository;

    // index
    @GetMapping
    public String index(Model model) {
        model.addAttribute("songs", songRepository.findAll());
        model.addAttribute("page", "songs");

        return new String("contentPage");
    }

    //search
    @GetMapping("/search")
    public String search(@RequestParam("name") String name, Model model) {
        model.addAttribute("songs", songRepository.findByNameContainingIgnoreCase(name));
        model.addAttribute("page", "songs");

        return new String("contentPage");
    }
    public String getMethodName(@RequestParam String param) {
        return new String();
    }
    

    // show
    @GetMapping("/{id}")
    public String show(@PathVariable Integer id, Model model) {
        model.addAttribute("item", songRepository.findById(id).get());
        model.addAttribute("page", "songs");

        return new String("showPage");
    }
    
    
    
}
