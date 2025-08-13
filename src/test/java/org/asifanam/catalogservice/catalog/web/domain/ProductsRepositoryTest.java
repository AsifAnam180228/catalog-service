package org.asifanam.catalogservice.catalog.web.domain;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
@DataJpaTest(
        properties = {
                "spring.test.database.replace=none",
                "spring.datasource.url=jdbc:tc:postgresql:17-alpine:///db",
        }
)
@Sql("/test-data.sql")
public class ProductsRepositoryTest {
    @Autowired
    private ProductsRepository productsRepository;

    @Test
    public void shouldFindAllProducts() {
        List<ProductsEntity> products = productsRepository.findAll();
        assertThat(products).hasSize(15);
    }

    //                                                                    ('P100','The Hunger Games','Winning will make you famous. Losing means certain death...','https://images.gr-assets.com/books/1447303603l/2767052.jpg', 34.0),
    @Test
    public void shouldFindProductByCode() {
        ProductsEntity product = productsRepository.findByCode("P100").orElseThrow();
        assertThat(product.getCode()).isEqualTo("P100");
        assertThat(product.getName()).isEqualTo("Hunger Games");

    }


}