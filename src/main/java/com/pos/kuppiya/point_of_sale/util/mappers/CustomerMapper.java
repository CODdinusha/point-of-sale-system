package com.pos.kuppiya.point_of_sale.util.mappers;

import com.pos.kuppiya.point_of_sale.dto.CustomerDTO;
import com.pos.kuppiya.point_of_sale.dto.response.ResposeActiveCustomerDTO;
import com.pos.kuppiya.point_of_sale.entity.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.context.annotation.Bean;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
    CustomerDTO entityToDto(Customer customer);

//    @Mapping(target = "customerName", source = "customer.customerName")
//    @Mapping(target = "contactNumbers", source = "customer.contactNumbers")
//    ResposeActiveCustomerDTO entityToResponseActiveCustomerDTO(Customer customer);
    List<CustomerDTO> entityListToDtoList(List<Customer> customers);


//    List<ResposeActiveCustomerDTO> entityListToDtoListOnlyName(List<Customer> customers);
}
