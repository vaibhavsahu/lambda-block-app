package com.vaibhav.lamdablock.lambdablockapp.Entity;

import com.vaibhav.lamdablock.lambdablockapp.enums.SHIPPINGSTATUS;
import com.vaibhav.lamdablock.lambdablockapp.generator.ShippingIdSequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Getter
@Setter
@Builder
@AllArgsConstructor
@Entity
@Table(name="DD_SHIPMENT_INFO")
public class ShipmentInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "shipment_seq")
    @GenericGenerator(name = "shipment_seq",
            strategy = "com.vaibhav.lamdablock.lambdablockapp.generator.ShippingIdSequenceGenerator",
            parameters = {@Parameter(name= ShippingIdSequenceGenerator.INCREMENT_PARAM, value="5"),
                    @Parameter(name= ShippingIdSequenceGenerator.VALUE_PREFIX_PARAMETER, value="SHIP"),
                    @Parameter(name= ShippingIdSequenceGenerator.NUMBER_FORMAT_PARAMETER, value="%05d")})
    @Column(name="SHIPPING_ID", unique = true, updatable = false, nullable = false)
    private String shipmentId;

    @Column(name = "SHIIPING_LAT")
    private String latitude;

    @Column(name = "SHIPPING_LONG")
    private String longitude;

    @Column(name = "SHIPPING_STATUS")
    @Enumerated(EnumType.STRING)
    private SHIPPINGSTATUS shippingstatus;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "SHIPPING_CREATED_DATE")
    private Date createdDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "SHIPPING_MODIFIED_DATE")
    private Date modifiedDate;

    @Column(name = "SHIPPING_MODIFIED_BY")
    private String modifiedBy;

    public ShipmentInfo() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShipmentInfo that = (ShipmentInfo) o;
        return shipmentId.equals(that.shipmentId) &&
                latitude.equals(that.latitude) &&
                longitude.equals(that.longitude) &&
                shippingstatus == that.shippingstatus &&
                Objects.equals(createdDate, that.createdDate) &&
                Objects.equals(modifiedDate, that.modifiedDate) &&
                Objects.equals(modifiedBy, that.modifiedBy);
    }

    @Override
    public int hashCode() {
        return Objects.hash(shipmentId, latitude, longitude, shippingstatus, createdDate, modifiedDate, modifiedBy);
    }
}
