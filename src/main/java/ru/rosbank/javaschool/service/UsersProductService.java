package ru.rosbank.javaschool.service;

import ru.rosbank.javaschool.dto.FullProductDto;


public interface UsersProductService {

    boolean addToBasket(FullProductDto dto);
}
