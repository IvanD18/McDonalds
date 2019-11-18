package ru.rosbank.javaschool.product;

import ru.rosbank.javaschool.dto.FullProductDto;

import java.util.List;

public class Sandwich extends FullProductDto {
    private String name;

    public Sandwich(int id, String description, int price, List<String> composition, String name, boolean presence) {
        super(id, description, price, composition,presence);
        this.name = name;

    }
}
