package com.inditex.demo.mapper;

import com.inditex.demo.domain.Price;
import com.inditex.demo.dto.PriceDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface SimplePriceMapper {

    @Mapping(target = "brand", source = "brand.name")
    @Mapping(target = "priceTariffId", source = "priceListId")
    PriceDto priceToPriceDto(Price priceInfo);

    @Mapping(target = "priceListId", source = "priceTariffId")
    @Mapping(target = "brand", ignore = true)
    @Mapping(target = "priority", ignore = true)
    Price priceDtoToPrice(PriceDto priceDto);
}
