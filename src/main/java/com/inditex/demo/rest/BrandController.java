package com.inditex.demo.rest;

import com.inditex.demo.dto.BrandDto;
import com.inditex.demo.mapper.SimpleBrandMapperImpl;
import com.inditex.demo.service.BrandServiceImpl;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/brands")
@FieldDefaults(makeFinal = true)
public class BrandController {

    private final BrandServiceImpl brandService;
    private final SimpleBrandMapperImpl mapper;

    public BrandController(BrandServiceImpl brandService, SimpleBrandMapperImpl mapper) {
        this.brandService = brandService;
        this.mapper = mapper;
    }


    @GetMapping()
    public List<BrandDto> getAllBrands() {
        return brandService.getAllBrands().stream().map(mapper::brandToBrandDto).toList();
    }
}