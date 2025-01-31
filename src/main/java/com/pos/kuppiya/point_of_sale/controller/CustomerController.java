package com.pos.kuppiya.point_of_sale.controller;


import com.pos.kuppiya.point_of_sale.dto.CustomerDTO;
import com.pos.kuppiya.point_of_sale.dto.request.CustomerSaveRequestDTO;
import com.pos.kuppiya.point_of_sale.dto.request.CustomerUpdateRequestDTO;
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

}
