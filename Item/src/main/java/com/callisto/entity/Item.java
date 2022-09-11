package com.callisto.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Item {
    @Id
    @SequenceGenerator(name = "item_id_sequence", sequenceName = "item_id_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "item_id_sequence")
    private Long id;

    private Long productId;
    private Long brandId;
    private Long supplierId;
    private Long orderId;

    private String sku;

    private BigDecimal mrp;
    private BigDecimal discount;
    private BigDecimal price;

    private int quantity;
    private int sold;
    private int available;
    private int defective;

    private Long createdBy;
    private Long updatedBy;

    private Date createdAt;
    private Date updatedAt;
}
