package com.callisto.controller;

import com.callisto.entity.Item;
import com.callisto.entity.ItemRequest;
import com.callisto.service.ItemService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("api/v1/item")
public class ItemController {
    @Autowired
    private ItemService itemService;

    @PostMapping("/")
    public Item addItem(@RequestBody ItemRequest itemRequest) {
        log.info("inside controller addItem {} ", itemRequest);
        return itemService.saveItem(itemRequest);
    }

    @GetMapping("/{id}")
    public Item findItemById(@PathVariable("id") Long Id) {
        log.info("inside controller findItemById");
        return itemService.findItemById(Id);
    }
}
