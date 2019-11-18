package ru.rosbank.javaschool.model;

import ru.rosbank.javaschool.dto.FullProductDto;

import java.util.List;

public class ProductModel {
    private int id;
    private String description;
    private int price;
    private List<String> composition;
    private boolean presence;


    public ProductModel() {
    }

    public ProductModel(int id, String description, int price, List<String> composition, boolean presence) {
        this.id = id;
        this.description = description;
        this.price = price;
        this.composition = composition;
        this.presence = presence;
    }


    public static ProductModel from(FullProductDto dto) {
        return new ProductModel(
                dto.getId(),
                dto.getDescription(),
                dto.getPrice(),
                dto.getComposition(),
                dto.getPresence()
        );
    }



    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public int getPrice() {
        return price;
    }

    public List<String> getComposition() {
        return composition;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setComposition(List<String> composition) {
        this.composition = composition;
    }

    public void setPresence(boolean presence) {
        this.presence = presence;
    }

    public boolean getPresence() {
        return presence;
    }



}
