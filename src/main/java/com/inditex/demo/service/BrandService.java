package com.inditex.demo.service;

import com.inditex.demo.domain.Brand;

import java.util.List;

public interface BrandService {

    List<Brand> getAllBrands();

    Brand getBrandByName(String name);
}
