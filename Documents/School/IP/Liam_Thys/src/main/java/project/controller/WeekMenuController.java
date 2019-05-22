package project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import project.model.DagMenu;
import project.model.MyService;
import project.model.WeekMenu;

import javax.validation.Valid;
import java.util.List;


@RestController
public class WeekMenuController {

    @Autowired
    MyService myService;

    @GetMapping("/weekmenus")
    public List<WeekMenu> getWeekMenus() {
        return myService.getWeekMenus();
    }

    @PostMapping("/dagmenu/add")
    @ResponseStatus(HttpStatus.CREATED)
    public WeekMenu createDagmenu(@RequestBody @Valid DagMenu dagMenu) {
        return myService.addDagMenu(dagMenu);
    }
    /*
    @PatchMapping("/dagmenu/change/{datum}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void changeDagMenu(@PathVariable("datum") @DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate datum, @RequestBody DagMenu dagMenu) {
        gerechtService.changeDagMenu(dagMenu);
    }*/
}
