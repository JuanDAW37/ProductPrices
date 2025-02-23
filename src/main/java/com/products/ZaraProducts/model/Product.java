package com.products.ZaraProducts.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Getter //Con esta anotación de Lombok, nos evitamos escribir los Getter
@Setter //Con esta anotación de Lombok, nos evitamos escribir los Setter
@AllArgsConstructor //Con esta anotación de Lombok, creamos un constructor con todos los argumentos
@NoArgsConstructor //Con esta anotación de Lombok, creamos un constructor sin argumentos
@Builder //Genera un patrón generador para una clase, esto permite crear instancias de la clase
@Entity
@Table(name="prices")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected int price_list;
    protected int brand_id;
    protected LocalDateTime start_date;
    protected LocalDateTime end_date;
    protected Long product_id;
    protected int priority;
    protected Double price;
    protected String curr;
}
