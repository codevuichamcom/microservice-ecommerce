package com.funny.code.order.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "t_order")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "order")
    private List<OrderLineItems> orderLineItemsList = new java.util.ArrayList<>();
}
