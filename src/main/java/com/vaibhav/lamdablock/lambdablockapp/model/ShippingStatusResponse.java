package com.vaibhav.lamdablock.lambdablockapp.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class ShippingStatusResponse {
    private String status;
    private String message;

    public ShippingStatusResponse(){}
}
