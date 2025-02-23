package com.products.ZaraProducts.api;

import com.products.ZaraProducts.model.Product;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface IProductService {
    Optional<Product> buscaProducts(LocalDateTime appDate, Long productId, int brandId);
}
