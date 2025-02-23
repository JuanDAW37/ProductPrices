package com.products.ZaraProducts.controller;

import com.products.ZaraProducts.exceptions.BadRequestException;
import com.products.ZaraProducts.exceptions.ResourceNotFoundException;
import com.products.ZaraProducts.model.Product;
import com.products.ZaraProducts.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController //Con esta anotación, se convierte la clase en un controlador para exponer la API
@RequestMapping("/api/zara") //Indicamos así la ruta para acceder a los endpoints
public class ProductController {

    @Autowired
    @Qualifier("MEMORY")//Así le indicamos que queremos usar el sufijo dado en el Service
    private ProductService productService;

    @GetMapping
    public ResponseEntity<Optional<Product>> buscaListaPrecios(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    LocalDateTime dateApp, @RequestParam Long productId, @RequestParam int brandId){
        if (dateApp == null || productId == null) {
            throw new BadRequestException("Faltan datos para la consulta...");//Excepción personalizada
        }
        Optional<Product> prod = productService.buscaProducts(dateApp, productId, brandId);
        if (prod.isPresent()){
            return ResponseEntity.ok(prod);
        }else {
            throw new ResourceNotFoundException("No hay datos...");//Excepción personalizada
        }
    }
}
