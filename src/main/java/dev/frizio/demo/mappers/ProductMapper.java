package dev.frizio.demo.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import dev.frizio.demo.dtos.ProductDto;
import dev.frizio.demo.models.Product;

@Mapper
public interface ProductMapper {
  
  ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);
  
  ProductDto productToproductDto(Product product);

}
