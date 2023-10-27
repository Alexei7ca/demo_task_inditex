package com.inditex.demo.service;

import com.inditex.demo.domain.Brand;
import com.inditex.demo.domain.Price;
import com.inditex.demo.repository.PriceRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
public class PriceServiceTest {

    @Mock
    private PriceRepository pricesRepository;

    @InjectMocks
    private PriceServiceImpl pricesService;

    private Price testPriceInfo;
    private List<Price> priceInfoList;

    @BeforeEach
    public void setUp() {
        testPriceInfo = new Price();
        priceInfoList = new ArrayList<>();
        priceInfoList.add(testPriceInfo);
    }

    @Test
    public void whenGetAllPrices_thenReturnPricesList() {
        when(pricesRepository.findAll()).thenReturn(priceInfoList);

        List<Price> found = pricesService.getAllPrices();
        assertThat(found).isEqualTo(priceInfoList);
        verify(pricesRepository).findAll();
    }

    @Test
    public void whenGetPriceById_thenReturnPrice() {
        Integer testId = 1;
        when(pricesRepository.findById(testId)).thenReturn(Optional.of(testPriceInfo));

        Price found = pricesService.getPriceById(testId);
        assertThat(found).isEqualTo(testPriceInfo);
        verify(pricesRepository).findById(testId);
    }

    @Test
    public void whenGetPrice_thenReturnPrice() {
        LocalDateTime testDate = LocalDateTime.now();
        Brand testBrand = new Brand();
        testBrand.setName("testBrand");
        testBrand.setId(5);
        int testProductId = 1;

        when(pricesRepository.findFirstPriceByProductBrandAndDate(testDate, testBrand, testProductId)).thenReturn(testPriceInfo);

        Price found = pricesService.getPrice(testDate, testBrand, testProductId);
        assertThat(found).isEqualTo(testPriceInfo);
        verify(pricesRepository).findFirstPriceByProductBrandAndDate(testDate, testBrand, testProductId);
    }

}
