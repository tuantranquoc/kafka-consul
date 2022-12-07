package com.example.tiki.common;

public enum EnumKafkaGroupId {
    GROUP_ID_NEW_PRODUCT ("tiki");
    private final String name;
    EnumKafkaGroupId(String newProduct) {
        name = newProduct;
    }
}
