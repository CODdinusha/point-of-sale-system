package com.pos.kuppiya.point_of_sale.controller;


import com.pos.kuppiya.point_of_sale.dto.CustomerDTO;
import com.pos.kuppiya.point_of_sale.dto.request.CostomerUpdateQueryRequestDTO;
import com.pos.kuppiya.point_of_sale.dto.request.CustomerSaveRequestDTO;
import com.pos.kuppiya.point_of_sale.dto.request.CustomerUpdateRequestDTO;
import com.pos.kuppiya.point_of_sale.dto.response.ResponseSalAddCustomerDTO;
import com.pos.kuppiya.point_of_sale.dto.response.ResposeActiveCustomerDTO;
import com.pos.kuppiya.point_of_sale.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;


    @PostMapping(path = "/save")
    public String saveCustomer(@RequestBody CustomerSaveRequestDTO customerSaveRequestDTO) {
        return customerService.addCustomer(customerSaveRequestDTO);
    }


    @PutMapping(path = "/update")
    public String updateCustomer(@RequestBody CustomerUpdateRequestDTO customerUpdateRequestDTO) {
        String updated = customerService.updateCustomer(customerUpdateRequestDTO);
        return updated;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public CustomerDTO getCustomerById(@PathVariable("id") int id) {
        return customerService.getCustomerById(id);
    }

    @GetMapping(
            path = {"/get-all-customers"}
    )
    public List<CustomerDTO> getAllCustomer() {
        List<CustomerDTO> allCustomers = customerService.getAllCustomers();
        return allCustomers;
    }

    @DeleteMapping(path = "/delete-customer/{id}")
        public String deleteCustomer(@PathVariable("id") int id) {
        return customerService.deleteCustomer(id);
}

    @GetMapping(
            path = {"/get-by-name"},
            params = {"name"}
    )
    public List<CustomerDTO> getCustomerByName(@RequestParam(value = "name") String customerName) throws ClassNotFoundException {
        List<CustomerDTO> getCustomer = customerService.getByName(customerName);
        return getCustomer;
    }
    @GetMapping(
            path = {"/get-by-active-states"}
    )
    public List<CustomerDTO> getCustomerByActiveState()throws ClassNotFoundException{
        List<CustomerDTO> getCustomer = customerService.getAllCustomerByActiveState();
        return getCustomer;
    }
    @GetMapping(
            path = {"/get-by-active-states-only-name"}
    )
    public List<ResposeActiveCustomerDTO> getCustomerByActiveStateOnlyName()throws ClassNotFoundException{
        List<ResposeActiveCustomerDTO> getCustomer = customerService.getAllCustomerByActiveStateOnlyName();
        return getCustomer;
    }
//    @PutMapping(path = "/update-query/{id}")
//    public String updateCustomerByQuery(@RequestBody CostomerUpdateQueryRequestDTO customerUpdateQueryRequestDTO,
//                                        @PathVariable (value = "id") int id) {
//        String updated = customerService.updateCustomerByQuery(customerUpdateQueryRequestDTO,id);
//        return updated;
//    }
@PutMapping(path = "/update-query/{id}")
public String updateCustomerByQuery(@RequestBody CostomerUpdateQueryRequestDTO customerUpdateQueryRequestDTO,
                                    @PathVariable(value = "id") int id) {
    String updated = customerService.updateCustomerByQuery(customerUpdateQueryRequestDTO, id);
    return updated;
}
    @GetMapping(
            path = {"/get-by-nic"},
            params = {"nic"}
    )
    public List<CustomerDTO> getCustomerByNic(@RequestParam(value = "nic") String nic) throws ClassNotFoundException {
        List<CustomerDTO> getCustomer = customerService.getByNic(nic);
        return getCustomer;
    }
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseSalAddCustomerDTO getSalAsddById(@PathVariable("id") int id) {
        return customerService.getSalAsddById(id);
    }
}
