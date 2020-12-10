package com.vaibhav.lamdablock.lambdablockapp;

import com.fasterxml.jackson.core.type.TypeReference;
import com.vaibhav.lamdablock.lambdablockapp.enums.SHIPPINGSTATUS;
import com.vaibhav.lamdablock.lambdablockapp.model.CustomerInfo;
import com.vaibhav.lamdablock.lambdablockapp.model.ShipmentInfo;
import com.vaibhav.lamdablock.lambdablockapp.model.UserInfo;
import com.vaibhav.lamdablock.lambdablockapp.repository.CustomerInfoRepository;
import com.vaibhav.lamdablock.lambdablockapp.repository.ShippingUpdateRepository;
import com.vaibhav.lamdablock.lambdablockapp.service.UserService;

//import org.apache.log4j.Logger;
import org.apache.commons.lang.time.DateUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;


@EnableJpaRepositories(basePackages = "com.vaibhav.lamdablock.lambdablockapp")
@SpringBootApplication
public class LambdaBlockAppApplication implements CommandLineRunner{

    @Autowired
    private ShippingUpdateRepository shippingUpdateRepository;

    @Autowired
    private CustomerInfoRepository customerInfoRepository;


    private static final Logger LOGGER = LogManager.getLogger(LambdaBlockAppApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(LambdaBlockAppApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        CustomerInfo customer1 = CustomerInfo.builder().id(123L).username("abcdef").password("abcdef").build();


        CustomerInfo customer2 = CustomerInfo.builder().id(456L).username("dffdds").password("awweww").build();

        CustomerInfo customer3 = CustomerInfo.builder().id(789L).username("vderfw").password("chufiko").build();

        CustomerInfo customer4 = CustomerInfo.builder().id(888L).username("wertyu").password("uytreww").build();

        ShipmentInfo shipment1 = ShipmentInfo.builder()
                .shipmentId("SHIP_00123")
                .latitude("26.83411")
                .longitude("116.490286")
                .createdDate(DateUtils.addMinutes(new Date(), 10))
                .shippingstatus(SHIPPINGSTATUS.PICKED)
                .build();

        ShipmentInfo shipment2 = ShipmentInfo.builder()
                .shipmentId("SHIP_00321")
                .latitude("47.7489727")
                .longitude("7.3507066")
                .createdDate(DateUtils.addMinutes(new Date(), 15))
                .shippingstatus(SHIPPINGSTATUS.PICKED)
                .build();

        ShipmentInfo shipment3 = ShipmentInfo.builder()
                .shipmentId("SHIP_00456")
                .latitude("-7.6492089")
                .longitude("111.4395128")
                .createdDate(DateUtils.addMinutes(new Date(), 20))
                .shippingstatus(SHIPPINGSTATUS.PICKED)
                .build();

        ShipmentInfo shipment4 = ShipmentInfo.builder()
                .shipmentId("SHIP_00654")
                .latitude("27.885191")
                .longitude("119.359142")
                .createdDate(DateUtils.addMinutes(new Date(), 25))
                .shippingstatus(SHIPPINGSTATUS.PICKED)
                .build();

        ShipmentInfo shipment5 = ShipmentInfo.builder()
                .shipmentId("SHIP_00567")
                .latitude("59.925597")
                .longitude("30.3406369")
                .createdDate(DateUtils.addMinutes(new Date(), 30))
                .shippingstatus(SHIPPINGSTATUS.PICKED)
                .build();

        ShipmentInfo shipment6 = ShipmentInfo.builder()
                .shipmentId("SHIP_00765")
                .latitude("7.9300961")
                .longitude("98.3417006")
                .createdDate(DateUtils.addMinutes(new Date(), 35))
                .shippingstatus(SHIPPINGSTATUS.PICKED)
                .build();

        ShipmentInfo shipment7 = ShipmentInfo.builder()
                .shipmentId("SHIP_00245")
                .latitude("47.0505635")
                .longitude("15.4828066")
                .createdDate(DateUtils.addMinutes(new Date(), 40))
                .shippingstatus(SHIPPINGSTATUS.PICKED)
                .build();

        Set<ShipmentInfo> shipmentsForFirstCustomer = new HashSet<>();
        shipmentsForFirstCustomer.add(shipment1);
        shipmentsForFirstCustomer.add(shipment2);
        shipmentsForFirstCustomer.add(shipment3);

        Set<ShipmentInfo> shipmentsForSecondCustomer = new HashSet<>();
        shipmentsForSecondCustomer.add(shipment4);
        shipmentsForSecondCustomer.add(shipment5);
        shipmentsForSecondCustomer.add(shipment6);
        shipmentsForSecondCustomer.add(shipment7);


        customer1.setShipments(shipmentsForFirstCustomer);
        customer2.setShipments(shipmentsForSecondCustomer);

        customerInfoRepository.saveAll(Arrays.asList(customer1, customer2));

        LOGGER.info("Saved all customers info and shipments");
    }
}
