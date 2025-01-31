package com.pos.kuppiya.point_of_sale.repo;

import com.pos.kuppiya.point_of_sale.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@EnableJpaRepositories
public interface CustomerRepo extends JpaRepository<Customer,Integer>  {


    List<Customer> findAllByCustomerNameEquals(String customerName);
}
