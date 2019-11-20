package ru.rosbank.javaschool.service;

import ru.rosbank.javaschool.dto.FullProductDto;

import ru.rosbank.javaschool.exception.DataSaveException;

import ru.rosbank.javaschool.model.ProductModel;
import ru.rosbank.javaschool.repository.BasketRepository;
import ru.rosbank.javaschool.repository.ProductRepository;


public class UsersProductServiceImpl implements UsersProductService {
    private final ProductRepository repository;
    private final BasketRepository basket;
    public UsersProductServiceImpl(ProductRepository repository, BasketRepository basket) {
        this.repository = repository;
        this.basket = basket;
    }



    @Override
    public boolean addToBasket(FullProductDto dto) {
        if(dto.getPresence()==false){
            throw new DataSaveException("Sorry. The product is out of stock. You may be interested in our new product. https://mcdonalds.ru/product/id_"+repository.lastAddId());
        }
        basket.add(ProductModel.from(dto));
        return true;
    }
}
