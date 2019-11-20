package ru.rosbank.javaschool.service;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.rosbank.javaschool.dto.FullProductDto;
import ru.rosbank.javaschool.exception.DataNotFoundException;
import ru.rosbank.javaschool.exception.InvalidDataException;
import ru.rosbank.javaschool.model.ProductModel;
import ru.rosbank.javaschool.repository.ProductRepository;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class AdministratorProductServiceImplTest {

    @Test
    void getAllShouldReturnNullNoItemsInRep() {
        ProductRepository repository = mock(ProductRepository.class);

        Collection<ProductModel> items = new LinkedList<>();
        Mockito.when(repository.getAll()).thenReturn(items);
        AdministratorProductServiceImpl service = new AdministratorProductServiceImpl(repository);
        assertNotNull(service.getAll());
    }//correct

    @Test
    void getAllShouldThrowNullPointerException() {
        ProductRepository repository = mock(ProductRepository.class);
        Mockito.when(repository.getAll()).thenReturn(null);
        AdministratorProductServiceImpl service = new AdministratorProductServiceImpl(repository);
        assertThrows(NullPointerException.class, () -> service.getAll());
    }//correct


    @Test
    void getByIdShouldThrowExceptionNoItemsInRep() {
        ProductRepository repository = mock(ProductRepository.class);
        doReturn(Optional.empty()).when(repository).getById(1);
        AdministratorProductServiceImpl service = new AdministratorProductServiceImpl(repository);
        assertThrows(DataNotFoundException.class, () -> service.getById(1));
    }//correct

    @Test
    void getByIdShouldThrowExceptionWhenNoSuchItemsInRep() {
        ProductRepository repository = mock(ProductRepository.class);
        repository.create(new ProductModel());
        AdministratorProductServiceImpl service = new AdministratorProductServiceImpl(repository);
        assertThrows(DataNotFoundException.class, () -> service.getById(2));
    }//correct


    @Test
    void save0MoreThenIdShouldThrowInvalidDataException() {
        ProductRepository repository = mock(ProductRepository.class);
        ProductModel model = new ProductModel();
        model.setId(-1);
        Mockito.when(repository.create(model)).thenReturn(model);
        AdministratorProductServiceImpl service = new AdministratorProductServiceImpl(repository);
        assertThrows(InvalidDataException.class, () -> service.save(FullProductDto.from(model)));
    }//correct

    @Test
    void save0MoreThenPriceShouldThrowInvalidDataException() {
        ProductRepository repository = mock(ProductRepository.class);
        ProductModel model = new ProductModel();
        model.setPrice(-1);
        Mockito.when(repository.create(model)).thenReturn(model);
        AdministratorProductServiceImpl service = new AdministratorProductServiceImpl(repository);
        assertThrows(InvalidDataException.class, () -> service.save(FullProductDto.from(model)));
    }//correct


    @Test
    void removeByNotRemovedByIdThrowDataNotFoundException() {
        ProductRepository repository = mock(ProductRepository.class);
        Mockito.when(repository.removeById(1)).thenReturn(false);
        AdministratorProductServiceImpl service = new AdministratorProductServiceImpl(repository);
        assertThrows(DataNotFoundException.class, () -> service.removeById(1));
    }//correct


}