package exam.project.backend.backend_project_exam.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
@RequestMapping("/")
public class HomePageController {

    @GetMapping
    public String getMethodName() {
        return new String("index");
    }
    
    
}
