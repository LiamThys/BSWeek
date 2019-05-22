package project.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.repo.GerechtRepository;
import project.repo.WeekMenuRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class MyService {

    @Autowired
    GerechtRepository gerechtRepository;
    @Autowired
    WeekMenuRepository weekMenuRepository;

    public MyService() {}

    // *************************
    // GERECHTEN
    // *************************

    public List<Gerecht> getGerechten() {
        return gerechtRepository.findAll();
    }

    public Gerecht findGerechtById(int id) {
        return gerechtRepository.findById(id).orElseThrow(IllegalArgumentException::new);
    }

    public void addGerecht(Gerecht g) {
        gerechtRepository.save(g);
    }

    public void updateGerecht(int id, Gerecht updatedGerecht) {
        updatedGerecht.setId(id);

        gerechtRepository.save(updatedGerecht);
    }

    public void deleteGerecht(int id) {
        gerechtRepository.deleteById(id);
    }

    public List<Gerecht> findGerechtByDescription(String d){
        List<Gerecht> gerechten = new ArrayList<>();

        gerechten = gerechtRepository.findByDescription(d);

        if(gerechten.isEmpty()) {
            throw new IllegalArgumentException();
        }else{
            return gerechten;
        }
    }

    // *************************
    // WEEKMENUS
    // *************************

    public List<WeekMenu> getWeekMenus(){
        return weekMenuRepository.findAll();
    }

    public WeekMenu findWeekMenuById(int id){
        return weekMenuRepository.findById(id).orElseThrow(IllegalArgumentException::new);
    }

    public void addWeekMenu(WeekMenu weekMenu){
        weekMenuRepository.save(weekMenu);
    }

    public void updateWeekMenu(int id, WeekMenu updatedWeekMenu){
        updatedWeekMenu.setWeekNr(id);

        weekMenuRepository.save(updatedWeekMenu);
    }

    public void deleteWeekmenu(int id){
        weekMenuRepository.deleteById(id);
    }

    public WeekMenu addDagMenu(DagMenu dagMenu){
        if(dagMenu == null) throw new IllegalArgumentException("Toevoegen van dagmenu is mislukt: geen dagmenu gegeven.");

        int weeknr = DateFormatter.getWeekNumberOfDate(dagMenu);

        WeekMenu w = weekMenuRepository.findWeekMenuByWeekNr(weeknr);

        if(w == null){
            WeekMenu weekMenu = new WeekMenu(weeknr);
            weekMenu.addDagmenu(dagMenu);
            weekMenuRepository.save(weekMenu);
        }else{
            w.addDagmenu(dagMenu);
            weekMenuRepository.save(w);
        }

        return weekMenuRepository.findWeekMenuByWeekNr(weeknr);
    }
}
