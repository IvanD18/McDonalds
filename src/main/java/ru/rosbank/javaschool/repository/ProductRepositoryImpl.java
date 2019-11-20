package ru.rosbank.javaschool.repository;

import ru.rosbank.javaschool.exception.*;

import ru.rosbank.javaschool.model.ProductModel;

import java.util.*;

public class ProductRepositoryImpl implements ProductRepository {
    private final Collection<ProductModel> items = new LinkedList<>();
    private int nextId = 1;


    @Override
    public Collection<ProductModel> getAll() {
        return Collections.unmodifiableCollection(items);
    }

    @Override
    public Optional<ProductModel> getById(int id) {

        return items.stream()
                .filter(o -> o.getId() == id)
                .findFirst()
                ;
    }

    @Override
    public ProductModel create(ProductModel item) {
        item.setId(nextId++);
        items.add(item);
        return item;
    }

    @Override
    public ProductModel update(ProductModel item) {


        for (ProductModel model : items) {
            if (model.getId() == item.getId()) {
                model.setPrice(item.getPrice());
                model.setDescription(item.getDescription());
                model.setComposition(item.getComposition());
                model.setPresence(item.getPresence());
                return model;
            }
        }

        throw new DataSaveException("Item with id = " + item.getId() + " not found.");
    }

    @Override
    public int lastAddId() {
        return nextId - 1;
    }


    @Override
    public boolean removeById(int id) {
        return items.removeIf(o -> o.getId() == id);
    }
}
