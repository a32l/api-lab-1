package ru.mtuci.antonapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.mtuci.antonapi.dao.CatalogRepository;

@Component
public class CommandLineAppStartupRunner {

    private final CatalogRepository catalogRepository;

    @Autowired
    public CommandLineAppStartupRunner(CatalogRepository catalogRepository){
        this.catalogRepository = catalogRepository;
    }

    public void run(String...args) throws Exception {
        System.out.println(catalogRepository.findAll());
    }
}
