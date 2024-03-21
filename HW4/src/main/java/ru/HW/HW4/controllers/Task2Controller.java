package ru.HW.HW4.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Task2Controller {
    @GetMapping("/var/{name}/{number}")
    public String showVariableOne(@PathVariable("name") String name,
                                  @PathVariable("number") int number,
                                  Model model)
    {
        model.addAttribute("name", name);
        model.addAttribute("number", number);
        return "variable";
    }

    @RequestMapping("/var")
    public String showVariableTwo(Model model){
        model.addAttribute("name", "4e6uPaLLIKa");
        model.addAttribute("number", 152);
        return "variable";
    }
}
