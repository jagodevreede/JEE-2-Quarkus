package com.acme.inventory;

import lombok.Builder;
import lombok.Value;

import java.math.BigDecimal;

@Builder
@Value
public class ProductDTO {
    int id;
    String name;
    String brand;
    String category;
    short modelYear;
    BigDecimal listPrice;
}
