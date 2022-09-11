package com.callisto.entity;

import java.math.BigDecimal;

public record ItemRequest(Long productId, Long brandId, Long supplierId, Long orderId, String sku, BigDecimal mrp,
                          BigDecimal discount, BigDecimal price, int quantity, int sold, int available, int defective) {

}
