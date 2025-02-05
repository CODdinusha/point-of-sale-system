package com.pos.kuppiya.point_of_sale.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ResponseSalAddCustomerDTO {

    private String customerAddress;
    private Double salary;

}
