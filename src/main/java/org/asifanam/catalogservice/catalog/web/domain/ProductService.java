package org.asifanam.catalogservice.catalog.web.domain;

import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ProductService {
    private final ProductsRepository productsRepository;
    private final ApplicationProperties applicationProperties;

    public ProductService(ProductsRepository productsRepository, ApplicationProperties applicationProperties) {
        this.productsRepository = productsRepository;
        this.applicationProperties = applicationProperties;
    }

    public PagedResult<Product> getProducts(int pageNo) {
        // TODO get all by page number
        Sort sort = Sort.by("name").ascending();
        pageNo = pageNo <= 1 ? 0 : pageNo - 1;
        Pageable pageable = PageRequest.of(pageNo, applicationProperties.pageSize(), sort);
        Page<Product> pagedResult = productsRepository.findAll(pageable).map(ProductMapper::toProduct);

        return new PagedResult<>(
                pagedResult.getContent(),
                pagedResult.getTotalElements(),
                pagedResult.getNumber() + 1,
                pagedResult.getTotalPages(),
                pagedResult.isFirst(),
                pagedResult.isLast(),
                pagedResult.hasNext(),
                pagedResult.hasPrevious());
    }

    public Optional<Product> getProductByCode(String code) {
        return productsRepository.findByCode(code).map(ProductMapper::toProduct);
    }
}
