package ru.rosbank.javaschool.dto;



import ru.rosbank.javaschool.model.ProductModel;

public class ProductDto {
    private int id;
    private int price;

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
