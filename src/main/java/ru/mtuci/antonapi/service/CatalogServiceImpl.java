package ru.mtuci.antonapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.mtuci.antonapi.dao.CatalogRepository;
import ru.mtuci.antonapi.model.Catalog;
import java.util.List;

@Service
public class CatalogServiceImpl implements CatalogService {

    private final CatalogRepository catalogRepository;

    @Autowired
    public CatalogServiceImpl(CatalogRepository catalogRepository) {
        this.catalogRepository = catalogRepository;

    }
    @Override
    public Catalog get(Long id) {
        return catalogRepository.findById(id).orElse(null);
    }

    @Override
    public List<Catalog> getAll() {
        return catalogRepository.findAll();
    }

    @Override
    public Catalog save(Catalog catalog) {
        return catalogRepository.save(catalog);
    }

    @Override
    public void delete(Long id) {
        catalogRepository.delete(id);
    }
}