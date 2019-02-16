package project.db;

import project.model.Gerecht;

import java.util.List;

public interface GerechtenDb {
    Gerecht get(String name);

    List<Gerecht> getAll();

    void add(Gerecht gerecht);

    void update(Gerecht gerecht);

    void delete(String title);

    List<Gerecht> sortProducts();

    List<Gerecht> getAllVegetarianProducts();

    List<Gerecht> getAllNonVegetarianProducts();
}
