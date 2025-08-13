package org.asifanam.catalogservice.catalog.web.controllers;

import org.asifanam.catalogservice.catalog.web.domain.PagedResult;
import org.asifanam.catalogservice.catalog.web.domain.Product;
import org.asifanam.catalogservice.catalog.web.domain.ProductNotFoundException;
import org.asifanam.catalogservice.catalog.web.domain.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/products")
class ProductsController {
    private final ProductService productService;

    ProductsController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    PagedResult<Product> getProducts(@RequestParam(value = "pageNo", defaultValue = "1") int pageNo) {

        return  productService.getProducts(pageNo);
    }
    @GetMapping("/{code}")
    public ResponseEntity<Product> getProductByCode(@PathVariable String code){
        return productService.getProductByCode(code).map(ResponseEntity::ok)
                .orElseThrow(()-> ProductNotFoundException.forCode(code));
    }
}
