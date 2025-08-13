package org.asifanam.catalogservice.catalog.web.domain;

class ProductMapper {
    static Product toProduct(ProductsEntity productsEntity) {
        return new Product(
                productsEntity.getCode(),
                productsEntity.getName(),
                productsEntity.getDescription(),
                productsEntity.getImageUrl(),
                productsEntity.getPrice());
    }
}
