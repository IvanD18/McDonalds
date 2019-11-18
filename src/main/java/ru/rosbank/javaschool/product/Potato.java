package ru.rosbank.javaschool.product;

import ru.rosbank.javaschool.dto.FullProductDto;

import java.util.List;

public class Potato extends FullProductDto {
    private String size;

    public Potato(int id, String description, int price, List<String> composition, String size, boolean presence) {
        super(id, description, price, composition,presence);
        this.size = size;
    }
}
