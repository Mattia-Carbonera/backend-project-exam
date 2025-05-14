package exam.project.backend.backend_project_exam.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import exam.project.backend.backend_project_exam.repositories.MovieRepository;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;




@Controller
@RequestMapping("/movies")
public class MoviesController {

    @Autowired
    private MovieRepository movieRepository;


    // index
    @GetMapping
    public String index(Model model) {
        model.addAttribute("movies", movieRepository.findAll());
        model.addAttribute("page", "movies");

        return new String("contentPage");
    }

    //search
    @GetMapping("/search")
    public String search(@RequestParam("title") String title, Model model) {
        model.addAttribute("movies", movieRepository.findByTitleContainingIgnoreCase(title));
        model.addAttribute("page", "movies");

        return new String("contentPage");
    }
    

    // show
    @GetMapping("/{id}")
    public String show(@PathVariable Integer id, Model model) {
        model.addAttribute("item", movieRepository.findById(id).get());
        model.addAttribute("page", "movies");

        return new String("showPage");
    }
    
    
    
}
