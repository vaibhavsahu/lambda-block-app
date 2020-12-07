package com.vaibhav.lamdablock.lambdablockapp.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.Objects;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class ShipmentStatusUpdateRequestDto {
    private Date fromDateTime;
    private Date toDateTime;

    public ShipmentStatusUpdateRequestDto(){}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShipmentStatusUpdateRequestDto that = (ShipmentStatusUpdateRequestDto) o;
        return fromDateTime.equals(that.fromDateTime) &&
                toDateTime.equals(that.toDateTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fromDateTime, toDateTime);
    }
}
