package com.products.ZaraProducts.model.dao;

import com.products.ZaraProducts.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface IProductRepository extends JpaRepository<Product, Long> {
    @Query(value="SELECT product_id, brand_id, price_list, start_date, end_date, price, curr, priority" +
            " FROM PRICES WHERE :appDate BETWEEN start_date AND end_date AND product_id = :productId" +
            " AND brand_id = :brandId ORDER BY priority DESC LIMIT 1", nativeQuery = true)
    public Optional<Product> buscarProducto(LocalDateTime appDate, Long productId, int brandId);
}
