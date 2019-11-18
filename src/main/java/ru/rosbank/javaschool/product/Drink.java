package ru.rosbank.javaschool.product;

import ru.rosbank.javaschool.dto.FullProductDto;

import java.util.List;

public class Drink extends FullProductDto {
    private String name;



    public Drink(int id, String description, int price, List<String> composition, String name, boolean presence) {
        super(id, description, price, composition,presence);
        this.name = name;

    }
}
