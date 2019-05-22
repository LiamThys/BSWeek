/**package project.database;

import project.model.DagMenu;
import project.model.DateFormatter;
import project.model.Gerecht;
import project.model.WeekMenu;

import java.time.LocalDate;
import java.time.temporal.WeekFields;
import java.util.*;

public class GerechtDb {

    private List<Gerecht> gerechten;
    private Map<Integer, WeekMenu> weekMenus;

    public GerechtDb() {
        this.gerechten = new ArrayList<>();
        this.weekMenus = new HashMap<>();
        addGerecht(new Gerecht("Veggieburger", 5, "veggie"));
        addGerecht(new Gerecht("Frieten", 5, "veggie"));
        addGerecht(new Gerecht("Wok Veggie", 5, "veggie"));
        addGerecht(new Gerecht("Fruit", 5, "veggie"));
        addGerecht(new Gerecht("Pizza 4 Kazen", 5, "veggie"));

        addGerecht(new Gerecht("Tomatensoep", 2.5, "soep"));
        addGerecht(new Gerecht("Wortelsoep", 2.5, "soep"));
        addGerecht(new Gerecht("Pompoensoep", 2.5, "soep"));
        addGerecht(new Gerecht("Erwtensoep", 2.5, "soep"));
        addGerecht(new Gerecht("Aspergesoep", 2.5, "soep"));

        addGerecht(new Gerecht("Vol au Vent", 5, "dagschotel"));
        addGerecht(new Gerecht("Balletjes in Tomatensaus", 5, "dagschotel"));
        addGerecht(new Gerecht("Steak", 5, "dagschotel"));
        addGerecht(new Gerecht("Hamrolletjes", 5, "dagschotel"));
        addGerecht(new Gerecht("Kabeljauw op vel", 5, "dagschotel"));
    }

    public void addDagMenuToWeekMenu(DagMenu dagMenu){
        int weeknr = DateFormatter.getWeekNumberOfDate(dagMenu);

        if(!weekMenus.containsKey(weeknr)){
            WeekMenu w = new WeekMenu(weeknr);
            weekMenus.put(w.getWeekNr(),w);
        }
        weekMenus.get(weeknr).addDagmenu(dagMenu);
    }

    public DagMenu getDagMenu(DagMenu dagMenu){
        int weeknr = DateFormatter.getWeekNumberOfDate(dagMenu);
        if(weekMenus.get(weeknr).getDagMenu(dagMenu) != null){
            return dagMenu;
        }else {
            throw new DBException("DagMenu is niet toegevoegd.");
        }
    }

    public void changeDagMenu(){

    }

    public List<DagMenu> getThisWeeksWeekMenu() {
        LocalDate datum = LocalDate.now();

        WeekFields weekFields = WeekFields.of(Locale.getDefault());

        if(this.weekMenus.containsKey(datum.get(weekFields.weekOfWeekBasedYear()))){
            return this.weekMenus.get(datum.get(weekFields.weekOfWeekBasedYear())).getGerechten();
        }else{
            throw new DBException("Weekmenu has not been added for this week.");
        }
    }

    public boolean addGerecht(Gerecht g) {
        if (g == null) throw new DBException("Invalid gerecht");
        if (gerechten.contains(g)) throw new DBException("Gerecht is already added");
        return this.gerechten.add(g);
    }

    public boolean removeGerecht(Gerecht g) {
        if (g == null) throw new DBException("Invalid gerecht");
        return this.gerechten.remove(g);
    }

    public Gerecht getGerechtByName(String d) {
        for (Gerecht g : getGerechten()) {
            if (g.getDescription().equals(d)) {
                return g;
            }
        }
        throw new DBException("Gerecht not in db");
    }

    public List<Gerecht> getGerechtenOfType(String type) {
        List<Gerecht> result = new ArrayList<>();
        for (Gerecht g : getGerechten()) {
            if (g.getType().toLowerCase().equals(type.toLowerCase())) {
                result.add(g);
            }
        }
        return result;
    }


    public List<Gerecht> getGerechten() {
        return this.gerechten;
    }
}*/