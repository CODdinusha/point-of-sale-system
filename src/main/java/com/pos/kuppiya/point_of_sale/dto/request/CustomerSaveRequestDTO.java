package com.pos.kuppiya.point_of_sale.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerSaveRequestDTO {
    private String customerName;
    private String customerAddress;
    private Double salary;
    private List<String> contactNumbers;
    private String nic;



}