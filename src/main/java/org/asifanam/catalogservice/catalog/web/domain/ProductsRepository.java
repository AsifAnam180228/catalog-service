package org.asifanam.catalogservice.catalog.web.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

interface ProductsRepository extends JpaRepository<ProductsEntity, Long> {
    Optional<ProductsEntity>findByCode(String code);
}
