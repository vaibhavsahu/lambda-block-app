package com.vaibhav.lamdablock.lambdablockapp.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.Objects;


@Getter
@Setter
@AllArgsConstructor
@Builder
public class ShippingStatusRequest {
    private Long customerId;
    private String shippingId;
    private String shipmentStatus;
    private Date createdDateTime;

    public ShippingStatusRequest() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShippingStatusRequest that = (ShippingStatusRequest) o;
        return customerId == that.customerId &&
                shippingId.equals(that.shippingId) &&
                shipmentStatus.equals(that.shipmentStatus) &&
                createdDateTime.equals(that.createdDateTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerId, shippingId, shipmentStatus, createdDateTime);
    }
}
