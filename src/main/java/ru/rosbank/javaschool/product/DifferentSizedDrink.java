package ru.rosbank.javaschool.product;

import java.util.List;

public class DifferentSizedDrink extends Drink {
    private double size;

    public DifferentSizedDrink(int id, String description, int price, List<String> composition, String name, boolean presence, double size) {
        super(id, description, price, composition, name, presence);
        this.size = size;
    }
}
