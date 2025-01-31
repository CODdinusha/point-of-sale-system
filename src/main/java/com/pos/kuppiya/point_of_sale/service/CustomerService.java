package com.pos.kuppiya.point_of_sale.service;

import com.pos.kuppiya.point_of_sale.dto.CustomerDTO;
import com.pos.kuppiya.point_of_sale.dto.request.CustomerSaveRequestDTO;
import com.pos.kuppiya.point_of_sale.dto.request.CustomerUpdateRequestDTO;

import java.util.List;

public interface CustomerService {

    String addCustomer(CustomerSaveRequestDTO customerSaveRequestDTO);


    String updateCustomer(CustomerUpdateRequestDTO customerUpdateRequestDTO);

    CustomerDTO getCustomerById(int id);

    List<CustomerDTO> getAllCustomers();

    String deleteCustomer(int id);

    List<CustomerDTO> getByName(String customerName) throws ClassNotFoundException;
}



