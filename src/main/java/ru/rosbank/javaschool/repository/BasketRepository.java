package ru.rosbank.javaschool.repository;

import ru.rosbank.javaschool.model.ProductModel;



public interface BasketRepository {

    ProductModel add(ProductModel dto);

    boolean removeById(int id);
}
