package ru.rosbank.javaschool.service;

import lombok.Data;
import lombok.val;
import org.junit.jupiter.api.Test;
import org.mockito.internal.matchers.Null;
import ru.rosbank.javaschool.dto.FullProductDto;
import ru.rosbank.javaschool.exception.DataNotFoundException;
import ru.rosbank.javaschool.model.ProductModel;
import ru.rosbank.javaschool.repository.ProductRepositoryImpl;
import ru.rosbank.javaschool.repository.ProductRepository;

import java.util.Collection;
import java.util.Collections;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

class AdministratorProductServiceImplTest {

    @Test
    void getAllShouldReturnNullNoItemsInRep() {
        ProductRepository repository= mock(ProductRepository.class);
        doReturn(Collections.emptyList()).when(repository).getAll();
        AdministratorProductServiceImpl service = new AdministratorProductServiceImpl(repository);
        assertNotNull(service.getAll());
    }
    @Test
    void getAllShouldReturnNotNullOneItemInRep() {
        ProductRepository repository= mock(ProductRepository.class);
        doReturn(Collections.emptyList()).when(repository).getAll();
        AdministratorProductServiceImpl service = new AdministratorProductServiceImpl(repository);
        assertNotNull(service.getAll());
    }


    @Test
    void getByIdShouldThrowExceptionNoItemsInRep() {
        ProductRepository repository= mock(ProductRepository.class);
        doReturn(Optional.empty()).when(repository).getById(1);
        AdministratorProductServiceImpl service = new AdministratorProductServiceImpl(repository);
        assertThrows(DataNotFoundException.class,()->service.getById(1));
    }

    @Test
    void getByIdShouldThrowExceptionWhenNoSuchItemsInRep() {
        ProductRepository repository= mock(ProductRepository.class);
        doReturn(Optional.empty()).when(repository).getById(anyInt());
        doReturn(Optional.of(new ProductModel())).when(repository).getById(1);

        AdministratorProductServiceImpl service = new AdministratorProductServiceImpl(repository);
        assertThrows(DataNotFoundException.class,()->service.getById(2));
    }

    @Test
    void getByIdShouldReturnDtoWhenItemsPresentInRep() {
        ProductRepository repository= mock(ProductRepository.class);
        doReturn(Optional.of(new ProductModel())).when(repository).getById(1);
        AdministratorProductServiceImpl service = new AdministratorProductServiceImpl(repository);
        assertNotNull(service.getById(1));
    }

    @Test
    void save() {


    }

    @Test
    void removeById() {
    }
}