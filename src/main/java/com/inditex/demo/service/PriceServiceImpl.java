package com.inditex.demo.service;

import com.inditex.demo.domain.Brand;
import com.inditex.demo.domain.Price;
import com.inditex.demo.repository.PriceRepository;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@FieldDefaults(makeFinal = true)
public class PriceServiceImpl implements PriceService {

    private final PriceRepository priceRepository;

    public PriceServiceImpl(PriceRepository priceRepository) {
        this.priceRepository = priceRepository;
    }

    @Transactional
    public List<Price> getAllPrices() {
        return priceRepository.findAll();
    }

    @Transactional
    public Price getPriceById(Integer id) {
        return priceRepository.findById(id).orElseThrow();
    }

    @Transactional
    public Price getPrice(LocalDateTime date, Brand brand, int productId) {
        return priceRepository.findFirstPriceByProductBrandAndDate(date, brand, productId);
    }
}

