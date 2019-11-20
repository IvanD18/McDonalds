package ru.rosbank.javaschool.service;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.rosbank.javaschool.dto.FullProductDto;
import ru.rosbank.javaschool.exception.DataNotFoundException;
import ru.rosbank.javaschool.exception.DataSaveException;
import ru.rosbank.javaschool.model.ProductModel;
import ru.rosbank.javaschool.repository.BasketRepository;
import ru.rosbank.javaschool.repository.ProductRepository;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

class UsersProductServiceImplTest {

    @Test
    void addToBasketShouldThrowException() {
        ProductRepository repository= mock(ProductRepository.class);
        BasketRepository basket=mock(BasketRepository.class);

        FullProductDto dto=new FullProductDto(false);

        UsersProductServiceImpl usersService=new UsersProductServiceImpl(repository,basket);
        assertThrows(DataSaveException.class,()->usersService.addToBasket(dto));
    }

    @Test
    void addToBasketCorrectAddedShouldReturnTrue() {
        ProductRepository repository= mock(ProductRepository.class);
        BasketRepository basket=mock(BasketRepository.class);

        FullProductDto dto=new FullProductDto(true);

        UsersProductServiceImpl usersService=new UsersProductServiceImpl(repository,basket);
        assertTrue(usersService.addToBasket(dto));
    }

}