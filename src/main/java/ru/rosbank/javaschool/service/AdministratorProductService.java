package ru.rosbank.javaschool.service;

import ru.rosbank.javaschool.dto.FullProductDto;
import ru.rosbank.javaschool.dto.ProductDto;

import java.util.List;

public interface AdministratorProductService {
    List<ProductDto> getAll();
    FullProductDto getById(int id);
    void save(FullProductDto dto);
    void removeById(int id);

}
