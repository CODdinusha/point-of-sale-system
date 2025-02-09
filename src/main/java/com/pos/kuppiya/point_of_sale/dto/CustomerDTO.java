
package com.pos.kuppiya.point_of_sale.dto;


import lombok.*;

import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class CustomerDTO {
    private int customerId;
    private String customerName;
    private String customerAddress;
    private Double salary;
    private List<String> contactNumbers ;
    private Boolean activeState;
    private String nic;

    public Boolean isActiveState() {
        return null;
    }

}
