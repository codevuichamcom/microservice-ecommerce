package com.funny.code.order.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "t_inventory")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Inventory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int productId;

    private int quantity;
}
