package com.inditex.demo.rest;

import com.inditex.demo.domain.Brand;
import com.inditex.demo.domain.Price;
import com.inditex.demo.dto.PriceDto;
import com.inditex.demo.exception.NotFoundException;
import com.inditex.demo.mapper.SimplePriceMapper;
import com.inditex.demo.service.BrandServiceImpl;
import com.inditex.demo.service.PriceService;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/prices")
@Slf4j
@FieldDefaults(makeFinal = true)
public class PriceController {

    private PriceService pricesService;
    private SimplePriceMapper mapper;
    private BrandServiceImpl brandService;

    public PriceController(PriceService pricesService, SimplePriceMapper mapper, BrandServiceImpl brandService) {
        this.pricesService = pricesService;
        this.mapper = mapper;
        this.brandService = brandService;
    }

    @GetMapping()
    public List<PriceDto> getAllPrices() {
        log.info("getAllPrices method was called");
        return pricesService.getAllPrices().stream().map(mapper::priceToPriceDto).toList();
    }

    @GetMapping("/{priceId}")
    public PriceDto getPriceById(@PathVariable(value = "priceId") int priceId) {
        log.info("getPriceById method was called");
        var price = pricesService.getPriceById(priceId);
        return mapper.priceToPriceDto(price);
    }

    @GetMapping("/price")   //   /api/prices/price?product_id=35455&brand=ZARA&date=2020-06-15T00:00
    public PriceDto getPrice(@RequestParam(name = "date") LocalDateTime date,
                             @RequestParam(name = "product_id") Integer productId,
                             @RequestParam(name = "brand") String brandName) {
        log.info("getPrice method was called");

        if (productId == null || productId <= 0) {
            throw new IllegalArgumentException("product_id is not valid");
        }

        Brand brand = brandService.getBrandByName(brandName);
        if (brand == null) {
            throw new NotFoundException("Brand " + brandName + " not found.");
        }

        Price info = pricesService.getPrice(date, brand, productId);
        if (info == null) {
            throw new NotFoundException("Price not found.");
        }
        return mapper.priceToPriceDto(info);
    }

}
