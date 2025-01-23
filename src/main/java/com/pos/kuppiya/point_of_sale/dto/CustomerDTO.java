package com.pos.kuppiya.point_of_sale.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Data

public class CustomerDTO {
    private int customerId;
    private String customerName;
    private String customerAddress;
    private Double salary;
    private List<String> contactNumbers ;
    private Boolean activeState;
    private String nic;

    public Boolean isActiveState() {
        return null;
    }

//    public CustomerDTO() {
//    }
//
//    public CustomerDTO(int customerId, String customerName, String customerAddress, Double salary, List<String> contactNumbers, Boolean activeState, String nic) {
//        this.customerId = customerId;
//        this.customerName = customerName;
//        this.customerAddress = customerAddress;
//        this.salary = salary;
//        this.contactNumbers = contactNumbers;
//        this.activeState = activeState;
//        this.nic = nic;
//    }
//
//    public int getCustomerId() {
//        return customerId;
//    }
//
//    public void setCustomerId(int customerId) {
//        this.customerId = customerId;
//    }
//
//    public String getCustomerName() {
//        return customerName;
//    }
//
//    public void setCustomerName(String customerName) {
//        this.customerName = customerName;
//    }
//
//    public String getCustomerAddress() {
//        return customerAddress;
//    }
//
//    public void setCustomerAddress(String customerAddress) {
//        this.customerAddress = customerAddress;
//    }
//
//    public Double getSalary() {
//        return salary;
//    }
//
//    public void setSalary(Double salary) {
//        this.salary = salary;
//    }
//
//    public List<String> getContactNumbers() {
//        return contactNumbers;
//    }
//
//    public void setContactNumbers(List<String> contactNumbers) {
//        this.contactNumbers = contactNumbers;
//    }
//
//    public Boolean getActiveState() {
//        return activeState;
//    }
//
//    public void setActiveState(Boolean activeState) {
//        this.activeState = activeState;
//    }
//
//    public String getNic() {
//        return nic;
//    }
//
//    public void setNic(String nic) {
//        this.nic = nic;
//    }
//
//    @Override
//    public String toString() {
//        return "CustomerDTO{" +
//                "customerId=" + customerId +
//                ", customerName='" + customerName + '\'' +
//                ", customerAddress='" + customerAddress + '\'' +
//                ", salary=" + salary +
//                ", contactNumbers=" + contactNumbers +
//                ", activeState=" + activeState +
//                ", nic='" + nic + '\'' +
//                '}';
//    }
}
