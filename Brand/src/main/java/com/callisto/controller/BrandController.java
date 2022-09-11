package com.callisto.controller;

import com.callisto.entity.Brand;
import com.callisto.entity.BrandRequest;
import com.callisto.service.BrandService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("api/v1/brand")
public class BrandController {
    @Autowired
    private BrandService brandService;

    @PostMapping("/")
    public Brand addBrand(@RequestBody BrandRequest brandRequest) {
        log.info("inside addBrand controller {} ", brandRequest);
        return brandService.saveBrand(brandRequest);
    }

    @GetMapping("/{id}")
    public Brand findBrandById(@PathVariable("id") Long id) {
        log.info("inside findBrandById controller");
        return brandService.findBrandById(id);
    }
}
