package project.model;

public class Gerecht {
    private String title;
    private double price;

    public Gerecht() {
    }

    public Gerecht(String title, double price) {
        this.title = title;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String toString(){
        return title + " " + price;
    }
}
