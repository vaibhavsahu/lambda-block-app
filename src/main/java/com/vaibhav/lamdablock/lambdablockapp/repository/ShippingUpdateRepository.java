package com.vaibhav.lamdablock.lambdablockapp.repository;

import com.vaibhav.lamdablock.lambdablockapp.Entity.ShipmentInfo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ShippingUpdateRepository extends CrudRepository<ShipmentInfo, String> {

    @Query("SELECT S FROM ShipmentInfo S WHERE S.createdDate >= :fromDate and S.createdDate <= :toDate")
    public List<ShipmentInfo> getShipmentInfoBetweenDates(Date fromDate, Date toDate);
}
