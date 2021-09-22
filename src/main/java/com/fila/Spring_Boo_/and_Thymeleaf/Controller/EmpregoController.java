package com.fila.Spring_Boo_.and_Thymeleaf.Controller;


import com.fila.Spring_Boo_.and_Thymeleaf.Model.Emprego;
import com.fila.Spring_Boo_.and_Thymeleaf.Repository.EmpregoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
public class EmpregoController {

    @Autowired
    EmpregoRepository repository;

    @RequestMapping("/")
    public String listaEmpregos(Model model){

        model.addAttribute("empregos", repository.findAll());

        return "lista";

    }

    @GetMapping("/add")
    public String empregoForm(Model model){

        model.addAttribute("emprego", new Emprego());

        return "empregoForm";

    }

    @PostMapping("/process")
    public String processForm(@Valid Emprego emprego, BindingResult result){
        if(result.hasErrors()){
            return "empregoForm";
        }

        repository.save(emprego);

        return "redirect:/";
    }
}
