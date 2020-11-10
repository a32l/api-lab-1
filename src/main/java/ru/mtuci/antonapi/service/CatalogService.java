package ru.mtuci.antonapi.service;

import ru.mtuci.antonapi.model.Catalog;
import java.util.List;

public interface CatalogService {
    Catalog get(Long id);

    List<Catalog> getAll();

    Catalog save(Catalog catalog);

    void delete(Long id);
}