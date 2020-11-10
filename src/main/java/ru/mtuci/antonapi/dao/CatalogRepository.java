package ru.mtuci.antonapi.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import ru.mtuci.antonapi.model.Catalog;

@Transactional(readOnly = true)

public interface CatalogRepository extends JpaRepository <Catalog, Long> {
    @Transactional
    @Modifying
    @Query("DELETE FROM Catalog p WHERE p.id=:id")
    int delete(@Param("id") Long id );
}