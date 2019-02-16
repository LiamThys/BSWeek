package project.db;

import project.model.Gerecht;

import java.util.ArrayList;
import java.util.List;

public class GerechtenDbDummyData implements GerechtenDb {
    List<Gerecht> gerechten = new ArrayList();

    public GerechtenDbDummyData() {
        gerechten.add(new Gerecht("Bloemkoolsoep",1));
        gerechten.add(new Gerecht("Tomatensoep",1));
        gerechten.add(new Gerecht("Pompoensoep",1));
        gerechten.add(new Gerecht("Cordon blue",4.20));
        gerechten.add(new Gerecht("Konijn met pruimen",4.20));
        gerechten.add(new Gerecht("Groetenlasagne",4));
        gerechten.add(new Gerecht("veggie pasta",4));
    }

    @Override
    public Gerecht get(String name) {
        Gerecht resultaat = null;

        for(Gerecht g: gerechten){
            if(g.getTitle().equals(name)){
                resultaat = g;
            }
        }

        return resultaat;
    }

    @Override
    public List<Gerecht> getAll() {
        return gerechten;
    }

    @Override
    public void add(Gerecht gerecht) {
        gerechten.add(gerecht);
    }

    @Override
    public void update(Gerecht gerecht) {
        String title = gerecht.getTitle();
        for(int i = 0; i < gerechten.size(); i++){
            if(title.equals(gerechten.get(i).getTitle())){
                gerechten.get(i).setPrice(gerecht.getPrice());
            }
        }
    }

    @Override
    public void delete(String title) {
        for(int i = 0; i < gerechten.size(); i++){
            if(title.equals(gerechten.get(i).getTitle())){
                gerechten.remove(i);
            }
        }
    }

    @Override
    public List<Gerecht> sortProducts() {
        return null;
    }

    @Override
    public List<Gerecht> getAllVegetarianProducts() {
        return null;
    }

    @Override
    public List<Gerecht> getAllNonVegetarianProducts() {
        return null;
    }
}
