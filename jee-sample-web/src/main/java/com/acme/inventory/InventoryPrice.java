package com.acme.inventory;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class InventoryPrice {
    BigDecimal price;
}
