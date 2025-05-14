package exam.project.backend.backend_project_exam.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import exam.project.backend.backend_project_exam.models.Game;
import exam.project.backend.backend_project_exam.repositories.GameRepository;
import exam.project.backend.backend_project_exam.repositories.PlatformRepository;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;










@Controller
@RequestMapping("/games")
public class GamesController {

    @Autowired
    private GameRepository gameRepository;

    @Autowired
    private PlatformRepository platformRepository;


    // index
    @GetMapping
    public String index(Model model) {
        model.addAttribute("games", gameRepository.findAll());
        model.addAttribute("page", "games");

        return new String("contentPage");
    }

    // search
    @GetMapping("/search")
    public String search(@RequestParam("name") String name, Model model) {

        model.addAttribute("games", gameRepository.findByNameContainingIgnoreCase(name));
        model.addAttribute("page", "games");

        return new String("contentPage");
    }
    

    // show
    @GetMapping("/{id}")
    public String show(@PathVariable Integer id, Model model) {
        model.addAttribute("item", gameRepository.findById(id).get());
        model.addAttribute("page", "games");

        return new String("showPage");
    }

    // Store
    @GetMapping("/create")
    public String create(Model model) {

        model.addAttribute("game", new Game());
        model.addAttribute("platforms", platformRepository.findAll());
        model.addAttribute("create", true);

        return new String("createUpdate");
    }

    @PostMapping("/create")
    public String store(@Valid @ModelAttribute("game") Game formGame, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "createUpdate";
        }

        gameRepository.save(formGame);
        
        model.addAttribute("page", "games");

        return new String("redirect:/games");
    }
    
    // edit

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {

        model.addAttribute("game", gameRepository.findById(id).get());
        model.addAttribute("platforms", platformRepository.findAll());
        model.addAttribute("create", false);

        return new String("createUpdate");
    }

    @PostMapping("/edit/{id}")
    public String update(@Valid @ModelAttribute("game") Game formGame, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return "createUpdate";
        }

        gameRepository.save(formGame);
        
        return new String("redirect:/games");
    }
    
    

    // delete
    @PostMapping("delete/{id}")
    public String delete(@PathVariable Integer id) {
    
        gameRepository.delete(gameRepository.findById(id).get());
        
        return new String("redirect:/games");
    }
    
    
    
    
}
