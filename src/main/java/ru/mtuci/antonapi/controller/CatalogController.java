package ru.mtuci.antonapi.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.mtuci.antonapi.model.Catalog;
import ru.mtuci.antonapi.service.CatalogService;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = CatalogController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class CatalogController {
    public static final String REST_URL = "/api/v1/catalog";

    private final CatalogService catalogService;

    @Autowired
    public CatalogController(CatalogService catalogService) {
        this.catalogService = catalogService;
    }

    @GetMapping(value = "/{id}")
    public Catalog get(@PathVariable("id") Long id) {
        log.info("get" + id);
        return catalogService.get(id);
    }


    @GetMapping
    public List<Catalog> getAll() {
        log.info("getAll");
        return catalogService.getAll();
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public Catalog save(@RequestBody Catalog catalog){
        log.info("save" + catalog);
        return catalogService.save(catalog);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") Long id) {
        log.info("delete" + id);
        catalogService.delete(id);
    }
}
