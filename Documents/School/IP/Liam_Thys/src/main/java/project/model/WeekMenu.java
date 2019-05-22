package project.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import project.database.DBException;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class WeekMenu implements Serializable {

    @NotNull
    @OneToMany(cascade = CascadeType.ALL)
    @OrderColumn(name = "INDEX")
    private List<DagMenu> dagMenus;

    @JsonIgnore
    @Id
    private int weekNr;

    public WeekMenu(int weekNr) {
        this.weekNr = weekNr;
        this.dagMenus = new ArrayList<>();
    }

    public WeekMenu() {
        this.dagMenus = new ArrayList<>();
    }


    public List<DagMenu> getGerechten() {
        return this.dagMenus;
    }

    public DagMenu getDagMenu(DagMenu dagMenu){
        for(DagMenu dm:dagMenus){
            dagMenu.equals(dm);
            return dagMenu;
        }
        return null;
    }

    public boolean addDagmenu(DagMenu d) {
        if (dagMenus.size() >= 5) throw new DomainException("Weekmenu kan niet groter dan 5 zijn");
        if (d == null) throw new DomainException("Geen gerecht om toe te voegen");
        for(DagMenu dm:dagMenus){
            if(d.equals(dm)) throw new DBException("Er bestaat al een dagmenu op deze dag");
        }
        return getGerechten().add(d);
    }

    public int getWeekNr() {
        return this.weekNr;
    }

    public void setWeekNr(int weekNummer) {
        if (weekNummer <= 0 || weekNummer >= 53) throw new DomainException("Weeknummer bestaat niet");
        this.weekNr = weekNummer;
    }
}