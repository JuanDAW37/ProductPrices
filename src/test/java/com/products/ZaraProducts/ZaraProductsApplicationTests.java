package com.products.ZaraProducts;

import com.products.ZaraProducts.model.Product;
import com.products.ZaraProducts.model.dao.IProductRepository;
import com.products.ZaraProducts.service.ProductService;
import jakarta.annotation.security.RunAs;
import net.bytebuddy.implementation.bind.annotation.RuntimeType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.TestPropertySource;
import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ZaraProductsApplicationTests {

	@Autowired
	ProductService productService;

	@Autowired
	IProductRepository productRepository;

	@BeforeEach
	public void setUp(){
		//Se crean 4 instancias, 1 por registro, efectuando una simulación.
		Product prod1 = new Product(1, 1,
				LocalDateTime.of(2020 ,6 , 14, 0,0, 0),
				LocalDateTime.of(2020, 12, 31, 23, 59, 59),
				35455L, 0, 35.50, "EUR");
		Product prod2 = new Product(2, 1,
				LocalDateTime.of(2020, 6, 14, 15, 0,0),
				LocalDateTime.of(2020, 6, 14, 18, 30, 0),
				35455L, 1, 25.45, "EUR");
		Product prod3 = new Product(3, 1,
				LocalDateTime.of(2020, 6, 15, 0, 0,0),
				LocalDateTime.of(2020, 6, 15, 11, 0, 0),
				35455L, 1, 30.50, "EUR");
		Product prod4 = new Product(4, 1,
				LocalDateTime.of(2020, 6, 15, 16, 0,0),
				LocalDateTime.of(2020, 12, 31, 23, 59, 59),
				35455L, 1, 38.95, "EUR");
		// Se guardan en memoria las 4 instancias
		productRepository.save(prod1);
		productRepository.save(prod2);
		productRepository.save(prod3);
		productRepository.save(prod4);
	}

	@Test
	public void Test1() throws Exception {
		System.out.println("Test1: petición a las 10:00 del día 14 del producto 35455 para la brand 1");
		LocalDateTime appDate = LocalDateTime.of(2020, 6, 14, 10, 0,0);
		Long productId = 35455L;
		int brandId = 1;
		// Llamada al servicio
		Optional<Product> applicableProduct = productService.buscaProducts(appDate, productId, brandId);
		// Aserciones
		assertTrue(applicableProduct.isPresent());
		Product prod = applicableProduct.get();
		assertEquals(productId, prod.getProduct_id());
		assertEquals(brandId, prod.getBrand_id());
		assertEquals(1, prod.getPrice_list());
		assertEquals(LocalDateTime.of(2020 ,6 , 14, 0,0, 0), prod.getStart_date());
		assertEquals(LocalDateTime.of(2020, 12, 31, 23, 59, 59), prod.getEnd_date());
		assertEquals(35.50, prod.getPrice());
	}

	@Test
	public void Test2() throws Exception {
		System.out.println("Test2: petición a las 16:00 del día 14 del producto 35455 para la brand 1");
		LocalDateTime appDate = LocalDateTime.of(2020, 6, 14, 16, 0,0);
		Long productId = 35455L;
		int brandId = 1;
		// Llamada al servicio
		Optional<Product> applicableProduct = productService.buscaProducts(appDate, productId, brandId);
		// Aserciones
		assertTrue(applicableProduct.isPresent());
		Product prod = applicableProduct.get();
		assertEquals(productId, prod.getProduct_id());
		assertEquals(brandId, prod.getBrand_id());
		assertEquals(2, prod.getPrice_list());
		assertEquals(LocalDateTime.of(2020 ,6 , 14, 15,0, 0), prod.getStart_date());
		assertEquals(LocalDateTime.of(2020, 6, 14, 18, 30, 0), prod.getEnd_date());
		assertEquals(25.45, prod.getPrice());
	}

	@Test
	public void Test3() throws Exception {
		System.out.println("Test3: petición a las 21:00 del día 14 del producto 35455 para la brand 1");
		LocalDateTime appDate = LocalDateTime.of(2020, 6, 14, 21, 0,0);
		Long productId = 35455L;
		int brandId = 1;
		// Llamada al servicio
		Optional<Product> applicableProduct = productService.buscaProducts(appDate, productId, brandId);
		// Aserciones
		assertTrue(applicableProduct.isPresent());
		Product prod = applicableProduct.get();
		assertEquals(productId, prod.getProduct_id());
		assertEquals(brandId, prod.getBrand_id());
		assertEquals(1, prod.getPrice_list());
		assertEquals(LocalDateTime.of(2020 ,6 , 14, 0,0, 0), prod.getStart_date());
		assertEquals(LocalDateTime.of(2020, 12, 31, 23, 59, 59), prod.getEnd_date());
		assertEquals(35.50, prod.getPrice());
	}

	@Test
	public void Test4() throws Exception {
		System.out.println("Test4: petición a las 10:00 del día 15 del producto 35455 para la brand 1");
		LocalDateTime appDate = LocalDateTime.of(2020, 6, 15, 10, 0,0);
		Long productId = 35455L;
		int brandId = 1;
		// Llamada al servicio
		Optional<Product> applicableProduct = productService.buscaProducts(appDate, productId, brandId);
		// Aserciones
		assertTrue(applicableProduct.isPresent());
		Product prod = applicableProduct.get();
		assertEquals(productId, prod.getProduct_id());
		assertEquals(brandId, prod.getBrand_id());
		assertEquals(3, prod.getPrice_list());
		assertEquals(LocalDateTime.of(2020 ,6 , 15, 0,0, 0), prod.getStart_date());
		assertEquals(LocalDateTime.of(2020, 6, 15, 11, 0, 0), prod.getEnd_date());
		assertEquals(30.50, prod.getPrice());
	}

	@Test
	public void Test5() throws Exception {
		System.out.println("Test5: petición a las 21:00 del día 16 del producto 35455 para la brand 1");
		LocalDateTime appDate = LocalDateTime.of(2020, 6, 16, 21, 0,0);
		Long productId = 35455L;
		int brandId = 1;
		// Llamada al servicio
		Optional<Product> applicableProduct = productService.buscaProducts(appDate, productId, brandId);
		// Aserciones
		assertTrue(applicableProduct.isPresent());
		Product prod = applicableProduct.get();
		assertEquals(productId, prod.getProduct_id());
		assertEquals(brandId, prod.getBrand_id());
		assertEquals(4, prod.getPrice_list());
		assertEquals(LocalDateTime.of(2020 ,6 , 15, 16,0, 0), prod.getStart_date());
		assertEquals(LocalDateTime.of(2020, 12, 31, 23, 59, 59), prod.getEnd_date());
		assertEquals(38.95, prod.getPrice());
	}
}
