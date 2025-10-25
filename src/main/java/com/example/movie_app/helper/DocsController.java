package com.example.movie_app.helper;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DocsController {
    @GetMapping("/docs")
    public String getScalarDocumentation(){
        return "redirect:/docs.html";
    }
}
