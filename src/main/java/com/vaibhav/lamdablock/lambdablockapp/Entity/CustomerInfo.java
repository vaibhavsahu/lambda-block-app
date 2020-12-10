package com.vaibhav.lamdablock.lambdablockapp.Entity;



import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;


@Getter
@Setter
@AllArgsConstructor
@Builder
@Entity
@Table(name="DD_CUSTOMER_INFO")
public class CustomerInfo {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="CUST_ID", unique = true,  nullable = false)
    private Long id;

    @Column(name = "CUST_NAME")
    private String username;

    @Column(name = "CUST_PASSWORD")
    private String password;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "DD_CUSTOMER_SHIPMENT_INFO",
            joinColumns = @JoinColumn(name = "CUSTOMER_ID", referencedColumnName = "CUST_ID"),
            inverseJoinColumns = {@JoinColumn(name = "SHIPMENT_ID", referencedColumnName = "SHIPPING_ID"),
                    @JoinColumn(name = "SHIPPING_STATUS", referencedColumnName = "SHIPPING_STATUS"),
                    @JoinColumn(name = "SHIPPING_CREATED_DATE", referencedColumnName = "SHIPPING_CREATED_DATE")})
    private Set<ShipmentInfo> shipments;

    public CustomerInfo(){}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomerInfo that = (CustomerInfo) o;
        return id.equals(that.id) &&
                username.equals(that.username) &&
                Objects.equals(password, that.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, password);
    }
}
