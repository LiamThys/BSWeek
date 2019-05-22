package project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import project.database.DBException;
import project.model.Gerecht;
import project.model.MyService;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
public class GerechtController {

    @Autowired
    private MyService myService;

    @GetMapping("/")
    public String root() {
        return "index";
    }

    @GetMapping(value = "/{locale:nl|en|fr}/gerechten")
    public String gerechten(Model model) {
        checkError(model);
        return "gerechten";
    }

    @GetMapping("/gerechten/change")
    public String changeGerechten(Model model) {
        checkError(model);
        return "changeGerechten";
    }

    @GetMapping("/gerechten/update/{id}")
    public String updateGerechtForm(@PathVariable("id") int id, Model model) {
        model.addAttribute("old", myService.findGerechtById(id));
        return "updateGerecht";
    }

    @PostMapping("/gerechten/update/{id}")
    public String updategerecht(@Valid Gerecht g, BindingResult bindingResult, @PathVariable("id") int id, Model model) {

        List<String> errors = new ArrayList<>();
        if (bindingResult.hasErrors()) {
            for (FieldError error : bindingResult.getFieldErrors()) {
                errors.add(error.getDefaultMessage());
            }
            model.addAttribute("errors", errors);
            return updateGerechtForm(id, model);
        } else {
            myService.findGerechtById(id);
            myService.updateGerecht(id, g);
            return changeGerechten(model);
        }
    }

    @GetMapping("/gerechten/delete/{id}")
    public String deleteGerechtForm(@PathVariable("id") String id, Model model) {
        model.addAttribute("id", id);
        return "deleteGerecht";
    }

    @PostMapping("/gerechten/delete/{id}")
    public String deleteGerecht(@PathVariable("id") int id, Model model) {
        myService.deleteGerecht(id);
        return this.changeGerechten(model);
    }

    @GetMapping("/gerechten/add")
    public String addGerechtForm(Model model) {
        return "addGerecht";
    }

    @PostMapping("/gerechten/add")
    public String addGerecht(@Valid Gerecht g, BindingResult bindingResult, Model model) {

        List<String> errors = new ArrayList<>();
        if (bindingResult.hasErrors()) {
            for (FieldError error : bindingResult.getFieldErrors()) {
                errors.add(error.toString());
            }
            System.out.println(errors);
            model.addAttribute("errors", errors);
            return addGerechtForm(model);
        } else {
            try {
                myService.addGerecht(g);
            } catch (DBException e) {
                errors.add(e.getMessage());
                model.addAttribute("errors", errors);
                return addGerechtForm(model);
            }
            return changeGerechten(model);
        }
    }

    private void checkError(Model model) {
        if (myService.getGerechten().size() == 0) {
            List<String> errors = new ArrayList<>();
            errors.add("Er zijn geen gerechten");
            model.addAttribute("errors", errors);
        } else {
            model.addAttribute("gerechten", myService.getGerechten());
        }
    }
}
