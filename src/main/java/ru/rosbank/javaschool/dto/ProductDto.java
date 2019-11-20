package ru.rosbank.javaschool.dto;



import ru.rosbank.javaschool.model.ProductModel;

public class ProductDto {
    private int id;
    private int price;

    public int getId() {
        return id;
    }

    public int getPrice() {
        return price;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public ProductDto(int id, int price) {
        this.id = id;
        this.price = price;
    }

    public static ProductDto from(ProductModel model) {
        return new ProductDto(
                model.getId(),
                model.getPrice()
        );
    }
}
