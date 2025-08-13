package org.asifanam.catalogservice.catalog.web.domain;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

interface ProductsRepository extends JpaRepository<ProductsEntity, Long> {
    Optional<ProductsEntity> findByCode(String code);
}
