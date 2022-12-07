package com.example.tiki.common;

public enum EnumKafkaTopic {
    NEW_PRODUCT ("newProduct");

    private final String name;
    EnumKafkaTopic(String topic) {
        name = topic;
    }
}
