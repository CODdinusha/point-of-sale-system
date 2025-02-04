package com.pos.kuppiya.point_of_sale.service.impl;
import com.pos.kuppiya.point_of_sale.dto.CustomerDTO;
import com.pos.kuppiya.point_of_sale.dto.request.CustomerSaveRequestDTO;
import com.pos.kuppiya.point_of_sale.dto.request.CustomerUpdateRequestDTO;
import com.pos.kuppiya.point_of_sale.dto.response.ResposeActiveCustomerDTO;
import com.pos.kuppiya.point_of_sale.entity.Customer;
import com.pos.kuppiya.point_of_sale.repo.CustomerRepo;
import com.pos.kuppiya.point_of_sale.service.CustomerService;
import com.pos.kuppiya.point_of_sale.util.mappers.CustomerMapper;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceIMPL implements CustomerService {

    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private CustomerMapper customerMapper;

    @Override
    public String addCustomer(CustomerSaveRequestDTO customerSaveRequestDTO) {
        Customer customer = new Customer();

        customer.setCustomerName(customerSaveRequestDTO.getCustomerName());
        customer.setCustomerAddress(customerSaveRequestDTO.getCustomerAddress());
        customer.setSalary(customerSaveRequestDTO.getSalary());
        customer.setContactNumbers(new ArrayList<>(customerSaveRequestDTO.getContactNumbers()));
        customer.setNic(customerSaveRequestDTO.getNic());


        if (!customerRepo.existsById(customer.getCustomerId())) {
            customerRepo.save(customer);
            return customer.getCustomerName() + "saved";
        } else {
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

        return "Updated success.";
    }

    @Override
    public CustomerDTO getCustomerById(int id) {
        Optional<Customer> customer = customerRepo.findById(id);
        if (customer.isPresent()) {
//            CustomerDTO customerDTO = modelMapper.map(customer.get(), CustomerDTO.class);
            CustomerDTO customerDTO = customerMapper.entityToDto(customer.get());
            return customerDTO;
        } else {
            System.out.println("not available");
        }
        return null;
    }

    @Override
    public List<CustomerDTO> getAllCustomers() {
        List<Customer> getCustomers = customerRepo.findAll();
        List<CustomerDTO> customerDTOList = new ArrayList<>();

//        for(Customer c: getCustomers){
//            CustomerDTO customerDTO = new CustomerDTO(
//                    c.getCustomerId(),
//                    c.getCustomerName(),
//                    c.getCustomerAddress(),
//                    c.getSalary(),
//                    c.getContactNumbers(),
//                    c.getActiveState(),
//                    c.getNic()
//
//            );
//            customerDTOList.add(customerDTO);
//        }

        List<CustomerDTO> customerDTOS = modelMapper.
                map(getCustomers, new TypeToken<List<CustomerDTO>>() {
                }.getType());
        return customerDTOS;
    }

    @Override
    public String deleteCustomer(int id) {
        if (customerRepo.existsById(id)) {
            customerRepo.deleteById(id);
            return "Customer with ID " + id + " has been deleted successfully.";
        } else {
            return "Customer with ID " + id + " not found. Cannot delete.";
        }
    }

    @Override
    public List<CustomerDTO> getByName(String customerName) throws ClassNotFoundException {
        List<Customer>customers = customerRepo.findAllByCustomerNameEquals(customerName);

        if(customers.size()!=0){
            List<CustomerDTO> customerDTOS = modelMapper.
                    map(customers, new TypeToken<List<CustomerDTO>>() {

                    }.getType());
            return customerDTOS;
        }else{
            throw new ClassNotFoundException("no results");
        }

    }

    @Override
    public List<CustomerDTO> getAllCustomerByActiveState() throws ClassNotFoundException {
        List<Customer>customers = customerRepo.findAllByActiveStateEquals(true);
        if(customers.size()!=0){
            List<CustomerDTO> customerDTOS = customerMapper.entityListToDtoList(customers);

            return customerDTOS;
        }else{
            throw new ClassNotFoundException("No Active Customer Found");
        }

    }

//    @Override
//    public List<ResposeActiveCustomerDTO> getAllCustomerByActiveStateOnlyName() throws ClassNotFoundException {
//        List<Customer>customers = customerRepo.findAllByActiveStateEquals(true);
//        if(customers.size()!=0){
//            List<ResposeActiveCustomerDTO> customerDTOS = customerMapper.entityListToDtoListOnlyName(customers);
//
//            return customerDTOS;
//        }else{
//            throw new ClassNotFoundException("No Active Customer Found");
//        }
//    }
@Override
public List<ResposeActiveCustomerDTO> getAllCustomerByActiveStateOnlyName() throws ClassNotFoundException {
    List<Customer> customers = customerRepo.findAllByActiveStateEquals(true);
    if (!customers.isEmpty()) {
        return customers.stream()
                .map(customer -> new ResposeActiveCustomerDTO(customer.getCustomerName(), customer.getContactNumbers()))
                .toList();
    } else {
        throw new ClassNotFoundException("No Active Customer Found");
    }
}



}


