package dev.frizio.demo.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.frizio.demo.dtos.ProductDto;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(value = "/products")
public class ProductController {

  @GetMapping(value = "")
  public List<ProductDto> getProducts() {
    log.info("Call getProducts");
    List<ProductDto> productDtos = new ArrayList<>();
    return productDtos;
  }

  @GetMapping(value = "/{id}")
  public ProductDto getProductById(@PathVariable int id) {
    log.info("Call getProductById");

    ProductDto productDto = new ProductDto();
    productDto.setName("Laptop");
    productDto.setPrice(699.90);

    return productDto;
  }

}
