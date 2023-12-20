package com.nomadspa.backend.SpaServiceCatalog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface SpaServiceCatalogRepository extends JpaRepository<SpaServiceCatalog,Long>{
    @Query("SELECT s FROM SpaServiceCatalog s WHERE s.serviceName = ?1")
    Optional<SpaServiceCatalog> findSpaServiceCatalogByServiceName(String serviceName);
}
