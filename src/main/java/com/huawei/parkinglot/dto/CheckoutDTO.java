package com.huawei.parkinglot.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class CheckoutDTO {

    private Double price;
    private long hour;
    private String plate;
}
