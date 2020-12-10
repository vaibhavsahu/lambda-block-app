package com.vaibhav.lamdablock.lambdablockapp.service;

import com.vaibhav.lamdablock.lambdablockapp.Entity.ShipmentInfo;
import com.vaibhav.lamdablock.lambdablockapp.repository.ShippingUpdateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ShippingUpdateService {

    @Autowired
    private ShippingUpdateRepository shippingUpdateRepository;

    public List<ShipmentInfo> getShipmentsBetweenDates(Date fromDate, Date toDate){
        return shippingUpdateRepository.getShipmentInfoBetweenDates(fromDate, toDate);
    }

}
