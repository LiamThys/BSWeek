package project.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class DagMenu implements Serializable {

    @NotEmpty(message = "Datum mag niet leeg zijn")
    @Id
    private String datum;

    @NotEmpty
    private String dag;

    @NotNull
    @OneToMany(cascade = CascadeType.ALL)
    @OrderColumn(name = "INDEX")
    private Gerecht[] gerechten;

    public DagMenu() {
        gerechten = new Gerecht[3];
    }

    public DagMenu(Gerecht[] gerechten) {
        this.gerechten = gerechten;
    }

    public DagMenu(String datum, String dag) {
        this();
        setDatum(datum);
        setDag(dag);
    }

    public DagMenu(String datum, String dag, Gerecht[] gerechten) {
        this();
        setDatum(datum);
        setDag(dag);
        setGerechten(gerechten);
    }

    public String getDatum() {
        return datum;
    }

    public void setDatum(String datum) {
        this.datum = datum;
    }

    public String getDag() {
        return dag;
    }

    public void setDag(String dag) {
        this.dag = dag;
    }

    public void setGerechten(Gerecht[] gerechten) {
        for(Gerecht gerecht:gerechten){
            typeCheck(gerecht);
        }
    }

    public void addGerecht(Gerecht gerecht){
        typeCheck(gerecht);
    }

    public void typeCheck(Gerecht gerecht){
        switch (gerecht.getType().toUpperCase()) {
            case "SOEP":
                this.gerechten[0] = gerecht;
                break;
            case "VEGGIE":
                this.gerechten[1] = gerecht;
                break;
            case "DAGSCHOTEL":
                this.gerechten[2] = gerecht;
                break;
            default:
                throw new DomainException("Ongeldig soort gerecht");
        }
    }

    public Gerecht[] getGerechten() {
        return this.gerechten;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DagMenu)) return false;
        DagMenu dagMenu = (DagMenu) o;
        return Objects.equals(datum, dagMenu.datum);
    }
}
