package com.example.peopleandcolor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.PostConstruct;

@Controller
public class HomeController {

    @Autowired
    ColorRepository colorRepository;

    @Autowired
    PeopleRepository peopleRepository;

    @RequestMapping("/")
    public String index(Model model){
        model.addAttribute("colors", colorRepository.findAll());
        model.addAttribute("people", peopleRepository.findAll());
        return "index";
    }

    @RequestMapping("/addcolor")
    public String addColor(Model model){
        model.addAttribute("color", new Colors());
        model.addAttribute("colorPeople", peopleRepository.findAll());
        return "color";
    }

    @RequestMapping("/savecolor")
    public String saveColor(@ModelAttribute("color") Colors colors , Model model){
        colorRepository.save(colors);
        return "redirect:/";
    }

    @PostConstruct
    public void fillPerson(){
        People p = new People();
        p.setName("Pratik");
        peopleRepository.save(p);

        p = new People();
        p.setName("Ujwal");
        peopleRepository.save(p);

        p = new People();
        p.setName("Kabin");
        peopleRepository.save(p);

    }
}
