package com.pos.kuppiya.point_of_sale.service.impl;

import com.pos.kuppiya.point_of_sale.dto.CustomerDTO;
import com.pos.kuppiya.point_of_sale.dto.request.CustomerSaveRequestDTO;
import com.pos.kuppiya.point_of_sale.dto.request.CustomerUpdateRequestDTO;
import com.pos.kuppiya.point_of_sale.entity.Customer;
import com.pos.kuppiya.point_of_sale.repo.CustomerRepo;
import com.pos.kuppiya.point_of_sale.service.CustomerService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceIMPL implements CustomerService {

@Autowired
    private CustomerRepo customerRepo;

@Autowired
    private ModelMapper modelMapper;

    @Override
    public String addCustomer(CustomerSaveRequestDTO customerSaveRequestDTO) {
        Customer customer = new Customer();

        customer.setCustomerName(customerSaveRequestDTO.getCustomerName());
        customer.setCustomerAddress(customerSaveRequestDTO.getCustomerAddress());
        customer.setSalary(customerSaveRequestDTO.getSalary());
        customer.setContactNumbers(new ArrayList<>(customerSaveRequestDTO.getContactNumbers()));
        customer.setNic(customerSaveRequestDTO.getNic());



        if(!customerRepo.existsById(customer.getCustomerId())){
            customerRepo.save(customer);
            return customer.getCustomerName()+"saved";
        }
       else {
            System.out.println("Name allready exist ");
            return "Name allready exist ";
        }

    }


    @Override
    public String updateCustomer(CustomerUpdateRequestDTO customerUpdateRequestDTO) {

        Optional<Customer> customer = customerRepo.findById(customerUpdateRequestDTO.getCustomerId());
        Customer customer1 = customer.get();


        customer1.setCustomerName(customerUpdateRequestDTO.getCustomerName());
        customer1.setCustomerAddress(customerUpdateRequestDTO.getCustomerAddress());
        customer1.setSalary(customerUpdateRequestDTO.getSalary());
        customer1.setContactNumbers(new ArrayList<>(customerUpdateRequestDTO.getContactNumbers()));
        customer1.setActiveState(customerUpdateRequestDTO.getActiveState());
        customer1.setNic(customerUpdateRequestDTO.getNic());

        customerRepo.save(customer1);

        return "Updated succes.";
    }

    @Override
    public CustomerDTO getCustomerById(int id) {
        Optional<Customer> customer = customerRepo.findById(id);
        if(customer.isPresent()){
//            CustomerDTO customerDTO = new CustomerDTO(
//
//                    customer.get().getCustomerId(),
//                    customer.get().getCustomerName(),
//                    customer.get().getCustomerAddress(),
//                    customer.get().getSalary(),
//                    customer.get().getContactNumbers(),
//                    customer.get().getActiveState(),
//                    customer.get().getNic()
//
//            );
//            return customerDTO;


            CustomerDTO customerDTO = modelMapper.map(customer.get(),CustomerDTO.class);
            return customerDTO;
        }else {
            System.out.println("not available");
        }
        return null;
    }

    @Override
    public List<CustomerDTO> getAllCustomers() {
        List<Customer>getCustomers = customerRepo.findAll();
        List<CustomerDTO>customerDTOList = new ArrayList<>();

        List<CustomerDTO> customerDTOS=modelMapper.
                map(getCustomers,new TypeToken<List<CustomerDTO>>(){}.getType());
        return customerDTOS;
    }




    @Override
    public boolean deleteCustomerById(int id) throws ClassNotFoundException {
        if(customerRepo.existsById(id)){
            customerRepo.deleteById(id);
        }else {
            throw new ClassNotFoundException("not found");
        }
        return false;
    }


}

