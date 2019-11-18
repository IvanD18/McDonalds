package ru.rosbank.javaschool.service;

import org.junit.jupiter.api.Test;
import ru.rosbank.javaschool.exception.DataNotFoundException;
import ru.rosbank.javaschool.repository.BasketRepository;
import ru.rosbank.javaschool.repository.ProductRepository;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

class UsersProductServiceImplTest {

    @Test
    void addToBasket() {
        ProductRepository repository= mock(ProductRepository.class);
        BasketRepository basket=mock(BasketRepository.class);

        AdministratorProductServiceImpl service = new AdministratorProductServiceImpl(repository);
        assertThrows(DataNotFoundException.class,()->service.getById(1));
    }
}