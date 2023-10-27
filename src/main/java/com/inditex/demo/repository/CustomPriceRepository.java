package com.inditex.demo.repository;

import com.inditex.demo.domain.Brand;
import com.inditex.demo.domain.Price;

import java.time.LocalDateTime;

public interface CustomPriceRepository {
    Price findFirstPriceByProductBrandAndDate(LocalDateTime date, Brand brand, int productId);
}

