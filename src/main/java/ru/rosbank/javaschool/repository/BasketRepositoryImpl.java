package ru.rosbank.javaschool.repository;

import ru.rosbank.javaschool.dto.FullProductDto;
import ru.rosbank.javaschool.model.ProductModel;

import java.util.Collection;
import java.util.LinkedList;

public class BasketRepositoryImpl implements BasketRepository {
    private final Collection<ProductModel> items = new LinkedList<>();
    private int nextId=1;
    @Override
    public ProductModel add(ProductModel item) {
        item.setId(nextId++);
        items.add(item);
        return item;
    }

    @Override
    public boolean removeById(int id) {return items.removeIf(o -> o.getId() == id);}
}
