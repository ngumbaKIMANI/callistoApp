package com.callisto.entity;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Builder
@AllArgsConstructor
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Item item = (Item) o;
        return id != null && Objects.equals(id, item.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
