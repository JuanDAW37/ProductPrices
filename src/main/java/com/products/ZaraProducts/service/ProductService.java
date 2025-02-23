package com.products.ZaraProducts.service;

import com.products.ZaraProducts.api.IProductService;
import com.products.ZaraProducts.model.Product;
import com.products.ZaraProducts.model.dao.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service("MEMORY")// Le indicamos que es un servicio y se almacenará en memoria
public class ProductService implements IProductService {

    @Autowired
    private IProductRepository iProductRepository;

    @Transactional(readOnly = true)
    @Override
    public Optional<Product> buscaProducts(LocalDateTime appDate, Long productId, int brandId) {
        return iProductRepository.buscarProducto(appDate,productId, brandId);
    }
}
