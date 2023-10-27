package com.inditex.demo.mapper;

import com.inditex.demo.domain.Brand;
import com.inditex.demo.dto.BrandDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SimpleBrandMapper {

    BrandDto brandToBrandDto(Brand brand);

    Brand brandDtoToBrand(BrandDto brandDto);
}
