package com.callisto.service;

import com.callisto.entity.Brand;
import com.callisto.entity.BrandRequest;
import com.callisto.repository.BrandRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class BrandService {
    @Autowired
    private BrandRepository brandRepository;

    public Brand saveBrand(BrandRequest brandRequest) {
        log.info("inside addBrand service {} ",brandRequest);
        Brand brand= Brand.builder().content(brandRequest.content()).summary(brandRequest.summary()).title(brandRequest.title()).build();
        return brandRepository.save(brand);
    }

    public Brand findBrandById(Long id) {
        return brandRepository.findItemById(id);
    }
}
