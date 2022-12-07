package com.example.tiki.dto;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {
    private String name;

    private String price;
}
