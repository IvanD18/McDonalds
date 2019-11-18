package ru.rosbank.javaschool.service;


import ru.rosbank.javaschool.dto.FullProductDto;
import ru.rosbank.javaschool.dto.ProductDto;
import ru.rosbank.javaschool.exception.InvalidDataException;
import ru.rosbank.javaschool.exception.DataNotFoundException;


import ru.rosbank.javaschool.model.ProductModel;
import ru.rosbank.javaschool.repository.ProductRepository;


import java.util.List;
import java.util.stream.Collectors;


public class AdministratorProductServiceImpl implements AdministratorProductService {
    private final ProductRepository repository;

    public AdministratorProductServiceImpl(ProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<ProductDto> getAll() {
        return repository.getAll().stream()
                .map((ProductModel model) -> ProductDto.from(model))
                .collect(Collectors.toList())
                ;
    }

    @Override
    public FullProductDto getById(int id) {
        return repository.getById(id)
                .map((ProductModel model) -> FullProductDto.from(model))
                .orElseThrow(DataNotFoundException::new)
                ;
    }


    @Override
    public void save(FullProductDto dto) {
        if (dto.getId() < 0) {
            throw new InvalidDataException("Id can't be negative");
        }

        if (dto.getPrice() < 0) {
            throw new InvalidDataException("Price can't be negative");
        }


        if (dto.getId() == 0) {
            repository.create(ProductModel.from(dto));
            return;
        }

        repository.update(ProductModel.from(dto));
    }

    @Override
    public void removeById(int id) {
        boolean removed = repository.removeById(id);
        if (!removed) {
            throw new DataNotFoundException();
        }
    }
}
