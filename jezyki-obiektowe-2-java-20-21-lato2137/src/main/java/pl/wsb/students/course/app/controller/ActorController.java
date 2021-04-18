package pl.wsb.students.course.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import pl.wsb.students.course.app.model.Actor;
import pl.wsb.students.course.app.service.ActorService;

@Controller
@RequestMapping("/actor")
public class ActorController {

    @Autowired
    private ActorService actorService;

    @GetMapping("")
    public String index(Model model) {
        model.addAttribute(
            "listActors",
            actorService.listAll()
        );
        return "actor/index";
    }

    @RequestMapping("/new")
    public String create(Model model) {
        Actor actor = new Actor();
        model.addAttribute("actor", actor);
        return "actor/new";
    }

    @RequestMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable(name = "id") int id) {
        ModelAndView modelAndView = new ModelAndView("actor/edit");
        modelAndView.addObject("actor", actorService.find(id));
        return modelAndView;
    }

    @PostMapping("/save")
    public String saveActor(@ModelAttribute("actor") Actor actor) {
        actorService.save(actor);
        return "redirect:/actor";
    }

    @RequestMapping("/delete/{id}")
    public String deleteActor(@PathVariable(name = "id") int id) {
        actorService.delete(id);
        return "redirect:/actor";
    }
}
