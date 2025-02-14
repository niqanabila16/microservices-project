package com.niqa.microservices.product.dto;

import java.math.BigDecimal; // Perbaikan impor BigDecimal

public record ProductResponse(String id, String name, String description, BigDecimal price) {
}
