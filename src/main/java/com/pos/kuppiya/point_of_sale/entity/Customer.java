package com.pos.kuppiya.point_of_sale.entity;
import org.hibernate.annotations.JdbcTypeCode;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.type.SqlTypes;


import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id", nullable = false, unique = true)
    private int customerId;

    @Column(name = "customer_name", nullable = false)
    private String customerName;

    @Column(name = "customer_address", nullable = true)
    private String customerAddress;

    @Column(name = "salary", nullable = true)
    private Double salary;


    @Column(name = "contact_numbers")
    @JdbcTypeCode(SqlTypes.JSON)
    private ArrayList contactNumbers;



    @Column(name = "active_state", nullable = true, columnDefinition = "BOOLEAN DEFAULT TRUE")
    private Boolean activeState;

    @Column(name = "nic", nullable = false, unique = true)
    private String nic;


}
