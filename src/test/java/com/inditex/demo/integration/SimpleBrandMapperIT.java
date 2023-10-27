package com.inditex.demo.integration;

import com.inditex.demo.domain.Brand;
import com.inditex.demo.dto.BrandDto;
import com.inditex.demo.mapper.SimpleBrandMapperImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class SimpleBrandMapperIT {

    private SimpleBrandMapperImpl mapper;

    @BeforeEach
    public void setUp() {
        mapper = new SimpleBrandMapperImpl();
    }

    @Test
    public void givenBrandToBrandDto_whenMaps_thenCorrect() {
        Brand brand = new Brand();
        brand.setId(1);
        brand.setName("ZARA");

        BrandDto brandDto = mapper.brandToBrandDto(brand);

        assertEquals(brand.getId(), brandDto.getId());
        assertEquals(brand.getName(), brandDto.getName());
    }

    @Test
    public void givenBrandDtoToBrand_whenMaps_thenCorrect() {
        BrandDto brandDto = new BrandDto();
        brandDto.setId(1);
        brandDto.setName("ZARA");

        Brand brand = mapper.brandDtoToBrand(brandDto);

        assertEquals(brandDto.getId(), brand.getId());
        assertEquals(brandDto.getName(), brand.getName());
    }

    @Test
    public void givenNullBrand_whenBrandToBrandDto_thenNullReturned() {
        BrandDto brandDto = mapper.brandToBrandDto(null);

        assertNull(brandDto);
    }

    @Test
    public void givenNullBrandDto_whenBrandDtoToBrand_thenNullReturned() {
        Brand brand = mapper.brandDtoToBrand(null);

        assertNull(brand);
    }
}

