package com.vaibhav.lamdablock.lambdablockapp.model;

import com.vaibhav.lamdablock.lambdablockapp.Entity.ShipmentInfo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Objects;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class ShipmentStatusUpdateResponseDto {
    private String status;
    private String message;
    private List<ShipmentInfo> data;

    public ShipmentStatusUpdateResponseDto(){}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShipmentStatusUpdateResponseDto that = (ShipmentStatusUpdateResponseDto) o;
        return status.equals(that.status) &&
                message.equals(that.message) &&
                data.equals(that.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(status, message, data);
    }
}
