package ru.rosbank.javaschool.service;

import ru.rosbank.javaschool.dto.FullProductDto;
import ru.rosbank.javaschool.dto.ProductDto;
import ru.rosbank.javaschool.model.ProductModel;

import java.util.List;
import java.util.Optional;

public interface UsersProductService {

    boolean addToBasket(FullProductDto dto);
}
