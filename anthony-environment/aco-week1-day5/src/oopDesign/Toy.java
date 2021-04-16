package oopDesign;

import java.io.*;

public abstract class Toy implements Serializable {
    private static final long serialVersionUID = 1l;
    private String name;
    private Float price;
    private Integer number;

    public String getName() {
        return name;
    }

    public Float getPrice() {
        return price;
    }

    public Integer getNumber() {
        return number;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }
}