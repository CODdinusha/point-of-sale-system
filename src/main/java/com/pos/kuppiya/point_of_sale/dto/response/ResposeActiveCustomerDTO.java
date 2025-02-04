package com.pos.kuppiya.point_of_sale.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ResposeActiveCustomerDTO {

    private String customerName;
    private List<String> contactNumbers ;


}
