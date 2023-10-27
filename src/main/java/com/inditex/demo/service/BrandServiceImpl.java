package com.inditex.demo.service;

import com.inditex.demo.domain.Brand;
import com.inditex.demo.repository.BrandRepository;
import jakarta.transaction.Transactional;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@FieldDefaults(makeFinal = true)
public class BrandServiceImpl implements BrandService{
    private BrandRepository brandsRepository;

    public BrandServiceImpl(BrandRepository brandsRepository) {
        this.brandsRepository = brandsRepository;
    }

    @Transactional
    public List<Brand> getAllBrands() {
        return brandsRepository.findAll();
    }

    @Transactional
    public Brand getBrandByName(String name) {
        return brandsRepository.findByName(name);
    }

}

