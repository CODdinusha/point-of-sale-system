package com.pos.kuppiya.point_of_sale.service;

import com.pos.kuppiya.point_of_sale.dto.CustomerDTO;
import com.pos.kuppiya.point_of_sale.dto.request.CostomerUpdateQueryRequestDTO;
import com.pos.kuppiya.point_of_sale.dto.request.CustomerSaveRequestDTO;
import com.pos.kuppiya.point_of_sale.dto.request.CustomerUpdateNameSalNicDTO;
import com.pos.kuppiya.point_of_sale.dto.request.CustomerUpdateRequestDTO;
//import com.pos.kuppiya.point_of_sale.dto.response.ResponseSalAddCustomerDTO;
import com.pos.kuppiya.point_of_sale.dto.response.ResponseSalAddCustomerDTO;
import com.pos.kuppiya.point_of_sale.dto.response.ResposeActiveCustomerDTO;

import java.util.List;

public interface CustomerService {

    String addCustomer(CustomerSaveRequestDTO customerSaveRequestDTO);


    String updateCustomer(CustomerUpdateRequestDTO customerUpdateRequestDTO);

    CustomerDTO getCustomerById(int id);

    List<CustomerDTO> getAllCustomers();

    String deleteCustomer(int id);

    List<CustomerDTO> getByName(String customerName) throws ClassNotFoundException;


    List<CustomerDTO> getAllCustomerByActiveState() throws ClassNotFoundException;
    List<CustomerDTO> getCustomerByActiveStatus(boolean b) throws ClassNotFoundException;



    List<ResposeActiveCustomerDTO> getAllCustomerByActiveStateOnlyName()throws ClassNotFoundException;

    String updateCustomerByQuery(CostomerUpdateQueryRequestDTO customerUpdateQueryRequestDTO,int id);


    List<CustomerDTO> getByNic(String nic) throws ClassNotFoundException;

    ResponseSalAddCustomerDTO getSalAddById(int id) throws ClassNotFoundException;

    String updateCustomerNameSalaryNicByQuery(CustomerUpdateNameSalNicDTO customerUpdateNameSalNicDTO, int id);




//    ResponseSalAddCustomerDTO getSalAddById(int id) throws ClassNotFoundException;
}



