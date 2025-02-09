package com.pos.kuppiya.point_of_sale.controller;


import com.pos.kuppiya.point_of_sale.dto.CustomerDTO;
import com.pos.kuppiya.point_of_sale.dto.request.CostomerUpdateQueryRequestDTO;
import com.pos.kuppiya.point_of_sale.dto.request.CustomerSaveRequestDTO;
import com.pos.kuppiya.point_of_sale.dto.request.CustomerUpdateNameSalNicDTO;
import com.pos.kuppiya.point_of_sale.dto.request.CustomerUpdateRequestDTO;
import com.pos.kuppiya.point_of_sale.dto.response.ResponseSalAddCustomerDTO;
import com.pos.kuppiya.point_of_sale.dto.response.ResposeActiveCustomerDTO;
import com.pos.kuppiya.point_of_sale.entity.Customer;
import com.pos.kuppiya.point_of_sale.repo.CustomerRepo;
import com.pos.kuppiya.point_of_sale.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private CustomerRepo customerRepo;


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
//    @GetMapping(
//            path = {"/get-by-active-states"}
//    )
//    public List<CustomerDTO> getCustomerByActiveState() throws ClassNotFoundException {
//        List<CustomerDTO> getCustomer = customerService.getAllCustomerByActiveState();
//        return getCustomer;
//    }


//    @GetMapping(path = "/get-by-active-states")
//    public ResponseEntity<List<CustomerDTO>> getCustomerByActiveState() throws ClassNotFoundException {
//       List<CustomerDTO> customers = customerService.getAllCustomerByActiveState();
//            if (customers.isEmpty()) {
//                return ResponseEntity.noContent().build();  // HTTP 204 No Content
//           }
//         return ResponseEntity.ok(customers);  // HTTP 200 OK
//    }

    @GetMapping("/get_by_active_status")
    public  ResponseEntity<List<CustomerDTO>> getCustomerByActiveStatus() throws ClassNotFoundException {
        List<CustomerDTO> customerDTOList =customerService.getCustomerByActiveStatus(true);
        return ResponseEntity.ok(customerDTOList);
    }




    @GetMapping("/activeCustomers")
    public List<Customer> activeCustomers() throws ClassNotFoundException {
        List<Customer> activeCustomers = customerRepo.findAllByActiveStateEquals(true);
        return activeCustomers;
    }






    @GetMapping(
            path = {"/get-by-active-states-only-name"}
    )
    public List<ResposeActiveCustomerDTO> getCustomerByActiveStateOnlyName() throws ClassNotFoundException {
        List<ResposeActiveCustomerDTO> getCustomer = customerService.getAllCustomerByActiveStateOnlyName();
        return getCustomer;
    }
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
    @GetMapping("get-sal-add-/{id}")
    public ResponseEntity<ResponseSalAddCustomerDTO> getSalAddById(@PathVariable("id") int id) throws ClassNotFoundException {
        ResponseSalAddCustomerDTO response = customerService.getSalAddById(id);
        return ResponseEntity.ok(response);
    }
    @PutMapping(path = "/update-query-name-salary-nic/{id}")
    public String updateCustomerNameSalaryNicByQuery(@RequestBody CustomerUpdateNameSalNicDTO customerUpdateNameSalNicDTO,
                                                     @PathVariable(value = "id") int id) {
        String updated = customerService.updateCustomerNameSalaryNicByQuery(customerUpdateNameSalNicDTO, id);
        return updated;
    }
}
