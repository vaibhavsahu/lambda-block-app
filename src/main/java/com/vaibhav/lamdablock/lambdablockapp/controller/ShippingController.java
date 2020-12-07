package com.vaibhav.lamdablock.lambdablockapp.controller;

import com.vaibhav.lamdablock.lambdablockapp.model.*;
import com.vaibhav.lamdablock.lambdablockapp.service.ShippingUpdateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RestController
public class ShippingController {

    @Autowired
    private ShippingUpdateService shippingUpdateService;

    @RequestMapping(value = "/api/updateShipmentStatus", method = RequestMethod.POST)
    public ResponseEntity<ShippingStatusResponse> updateShipmentStatus(
            @RequestBody ShippingStatusRequest shippingStatusRequest){
        if(Objects.isNull(shippingStatusRequest.getCustomerId())
                || Objects.isNull(shippingStatusRequest.getShipmentStatus())
                || Objects.isNull(shippingStatusRequest.getShippingId())
                || Objects.isNull(shippingStatusRequest.getCreatedDateTime())){
            ShippingStatusResponse shippingStatusResponse = ShippingStatusResponse.builder()
                    .status("failed")
                    .message("Invalid token")
                    .build();
            return ResponseEntity.badRequest().body(shippingStatusResponse);
        }
        ShippingStatusResponse shippingStatusResponse = ShippingStatusResponse.builder()
                .status("success")
                .message("Status updated successfully")
                .build();
        return ResponseEntity.ok().body(shippingStatusResponse);
    }


    @RequestMapping(value = "/api/getShippingUpdates", method = RequestMethod.POST)
    public ResponseEntity<ShipmentStatusUpdateResponseDto> getShipmentsBetweenDates(
            @RequestBody ShipmentStatusUpdateRequestDto shipmentStatusUpdateRequestDto){
        if(isValid(shipmentStatusUpdateRequestDto)){
            List<ShipmentInfo> shipments =
                    shippingUpdateService.getShipmentsBetweenDates(shipmentStatusUpdateRequestDto.getFromDateTime(),
                            shipmentStatusUpdateRequestDto.getToDateTime());
            ShipmentStatusUpdateResponseDto shipmentStatusUpdateResponseDto = ShipmentStatusUpdateResponseDto.builder()
                    .status("success")
                    .message("")
                    .data(shipments)
                    .build();
            return ResponseEntity.ok().body(shipmentStatusUpdateResponseDto);
        }

        ShipmentStatusUpdateResponseDto shipmentStatusUpdateResponseDto = ShipmentStatusUpdateResponseDto.builder()
                .status("failed")
                .message("")
                .data(new ArrayList<>())
                .build();
        return ResponseEntity.badRequest().body(shipmentStatusUpdateResponseDto);
    }

    private boolean isValid(ShipmentStatusUpdateRequestDto shipmentStatusUpdateRequestDto) {
        if(Objects.isNull(shipmentStatusUpdateRequestDto.getFromDateTime())
                || Objects.isNull(shipmentStatusUpdateRequestDto.getToDateTime())){
            return false;
        }
        return true;
    }

}
