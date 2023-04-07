package com.funny.code.product.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "t_product")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String description;
    private double price;
}
