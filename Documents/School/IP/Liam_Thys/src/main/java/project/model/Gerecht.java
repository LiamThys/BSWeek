package project.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Gerecht implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotEmpty
    @Size(min=5, max=50)
    private String description;

    @NotNull
    @DecimalMin("0.1")
    @DecimalMax("10.0")
    private double price;

    @NotEmpty
    private String type;

    public Gerecht(String desc, double price, String type) {
        setDescription(desc);
        setPrice(price);
        setType(type);
    }

    public Gerecht(String desc, double price) {
        setDescription(desc);
        setPrice(price);
    }

    public Gerecht() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Gerecht gerecht = (Gerecht) o;
        return Double.compare(gerecht.price, price) == 0 &&
                Objects.equals(description, gerecht.description) &&
                Objects.equals(type, gerecht.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(description, price, type);
    }
}
