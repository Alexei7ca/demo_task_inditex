package com.inditex.demo.service;

import com.inditex.demo.domain.Brand;
import com.inditex.demo.domain.Price;

import java.time.LocalDateTime;
import java.util.List;

public interface PriceService {
    List<Price> getAllPrices();

    Price getPriceById(Integer id);

    Price getPrice(LocalDateTime date, Brand brand, int productId);
}

