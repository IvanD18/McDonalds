package ru.rosbank.javaschool.product;

import java.util.List;

public class Water extends Drink {
    private String type;

    public Water(int id, String description, int price, List<String> composition, String name, boolean presence, String type) {
        super(id, description, price, composition, name, presence);
        this.type = type;
    }
}
