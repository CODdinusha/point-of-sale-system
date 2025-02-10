package com.pos.kuppiya.point_of_sale.repo;

import com.pos.kuppiya.point_of_sale.entity.Customer;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@EnableJpaRepositories
@Transactional
public interface CustomerRepo extends JpaRepository<Customer,Integer>  {

    List<Customer> findAllByCustomerNameEquals(String customerName);
    List<Customer> findAllByActiveStateEquals(boolean b)throws ClassNotFoundException;



    @Modifying
    @Query(value = "update customer set customer_name = ?1,nic = ?2 where customer_id = ?3", nativeQuery = true)
    void updateCustomerByQuery(String customerName, String nic, int id);

    Optional<Customer> findByNic(String nic);

    List<Customer> findByCustomerId(int id);
    @Modifying
    @Query(value = "update customer set customer_name = ?1,salary = ?2,nic = ?3 where customer_id = ?4", nativeQuery = true)
    void updateCustomerNameSalaryNicByQuery(String customerName, Double salary, String nic, int id);
}
