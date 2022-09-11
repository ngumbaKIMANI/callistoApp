package com.callisto.service;

import com.callisto.entity.Item;
import com.callisto.entity.ItemRequest;
import com.callisto.repository.ItemRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ItemService {
    private ItemRepository itemRepository;

    public Item saveItem(ItemRequest itemRequest) {
        log.info("inside service saveItem");
        Item item = Item.builder().productId(itemRequest.productId()).brandId(itemRequest.brandId()).supplierId(itemRequest.supplierId()).orderId(itemRequest.orderId()).sku(itemRequest.sku()).mrp(itemRequest.mrp()).discount(itemRequest.discount()).price(itemRequest.price()).quantity(itemRequest.quantity()).sold(itemRequest.sold()).available(itemRequest.available()).defective(itemRequest.defective()).build();
        return itemRepository.save(item);
    }

    public Item findItemById(Long id) {
        log.info("inside findItemById saveItem");
        return itemRepository.findItemById(id);
    }
}
