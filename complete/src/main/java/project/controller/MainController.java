package project.controller;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import project.db.GerechtenDbDummyData;
import project.model.Gerecht;

import javax.validation.Valid;

@Controller
public class MainController implements WebMvcConfigurer {
    GerechtenDbDummyData db = new GerechtenDbDummyData();

    /* methods index and mealoverview pages, gerechtenOverzicht gives an overview of all meals. STORY 01*/
    @GetMapping("/home")
    public String home(){
        return "index";
    }

    @GetMapping("/gerechten")
    public String gerechtenOverzicht(Model model){
        model.addAttribute("gerechten", db.getAll());
        return "gerechtenoverzicht";
    }
    /* END STORY 01*/

    /* Methods to change and delete meals. STORY 02*/

    @GetMapping("/updateForm/{title}")
    public String updateForm(@PathVariable("title") String title, Model model){
        model.addAttribute("gerecht", db.get(title));
        return "updateFormGerecht";
    }

    @PostMapping("/updateGerecht/")
    public String updateGerecht(@Valid Gerecht gerecht, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getFieldErrors());
        } else {
            db.update(gerecht);
            System.out.println(gerecht.toString());
            model.addAttribute("gerechten", db.getAll());
        }
        return "gerechtenoverzicht";
    }

    @GetMapping("/deleteGerecht/{title}")
    public String deleteGerecht(@PathVariable("title") String title, Model model){
        db.delete(title);
        model.addAttribute("gerechten", db.getAll());
        return "gerechtenoverzicht";
    }
    /* END STORY 02*/

    /* add function, adds a new meal to the database. STORY 03 */
    @GetMapping("/gerecht/add")
    public String addFeedbackForm() {
        return "addGerecht";
    }

    @PostMapping("/gerecht/add")
    public String addFeedback(@Valid Gerecht gerecht, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getFieldErrors());
            return "addGerecht";
        } else {
            db.add(gerecht);
            model.addAttribute("gerechten", db.getAll());
            return "gerechtenoverzicht";
        }
    }
    /* END STORY 03*/


    @ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Requested ID not found!")
    @ExceptionHandler(value = IllegalArgumentException.class)
    public void badIdExecptionHandler(){
        // really nothing to do here
    }
}
