package de.maksym.crud.controllers;

import de.maksym.crud.models.Person;
import de.maksym.crud.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/people")
public class PeopleController {

    private PersonRepository personRepository;

    @Autowired
    public PeopleController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @GetMapping()
    public String index(Model model){
        model.addAttribute("people", personRepository.findAll());
        return "/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model){
        model.addAttribute("person", personRepository.findById(id));
        return "/show";
    }

    @GetMapping("/newPerson")
    public String newPerson(@ModelAttribute("person") Person person){
        return "/new";
    }

    @PostMapping("/save")
    public String create(@ModelAttribute("person") Person person,
                         BindingResult bindingResult){
        if(bindingResult.hasErrors())
            return "/new";

        personRepository.save(person);
        return "redirect:/people";
    }

    @GetMapping("/deletePerson")
    public String deletePerson(){
        return "people/delete";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id){
        model.addAttribute("person", personRepository.findById(id));
        return "/edit";
    }

    @DeleteMapping("/remove")
    public String delete(@ModelAttribute("idDeletedPerson") int idDeletedPerson){
        personRepository.deleteById(idDeletedPerson);
        return "redirect:/people";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("person") Person editPerson,
                         BindingResult bindingResult){
        if(bindingResult.hasErrors())
            return "/edit";

        personRepository.save(editPerson);
        return "redirect:/people";
    }
}
