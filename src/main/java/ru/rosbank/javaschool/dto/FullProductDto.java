package ru.rosbank.javaschool.dto;


import ru.rosbank.javaschool.model.ProductModel;

import java.util.List;


public class FullProductDto {
    private int id;
    private String description;
    private int price;
    private List<String> composition;
    private boolean presence;

    public FullProductDto() {
    }

    public FullProductDto(int id, String description, int price, List<String> composition, boolean presence) {
        this.id = id;
        this.description = description;
        this.price = price;
        this.composition = composition;
        this.presence=presence;
    }

    public static FullProductDto from(ProductModel model) {
        return new FullProductDto(
                model.getId(),
                model.getDescription(),
                model.getPrice(),
                model.getComposition(),
                model.getPresence()
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
    public void setPresence() {
        this.presence = presence;
    }

    public boolean getPresence() {
        return presence;
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
}
