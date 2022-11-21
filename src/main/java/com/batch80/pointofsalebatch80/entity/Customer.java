package com.batch80.pointofsalebatch80.entity;

import com.vladmihalcea.hibernate.type.json.JsonType;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import javax.persistence.*;
import java.util.ArrayList;




@Entity
@Table(name = "customer")
@TypeDefs({
        @TypeDef(name = "json", typeClass = JsonType.class)
})
public class Customer {

    @Id
    @Column(name ="customer_id",length = 45)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int customerId;

    @Column(name = "customer_name", length = 100, nullable = false)
    private String customerName;

    @Column(name = "customer_address", length = 200)
    private String customerAddress;

    @Column(name = "customer_salary", length = 45)
    private double customerSalary;

    @Type(type = "json")
    @Column(name = "contact_number", columnDefinition = "json")
    private ArrayList contactNumber;

    @Column(name = "customer_nic", length = 15, nullable = false)
    private String nic;

    @Column(name = "active_state", columnDefinition = "TINYINT default 1")
    private boolean activeState;

    public Customer() { // no arg constructor
    }

    public Customer(int customerId, String customerName, String customerAddress, double customerSalary, ArrayList contactNumber, String nic, boolean activeState) {
        this.customerId = customerId;   //full arg constructor
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.customerSalary = customerSalary;
        this.contactNumber = contactNumber;
        this.nic = nic;
        this.activeState = activeState;
    }

    // Create getters
    public int getCustomerId() {
        return customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public double getCustomerSalary() {
        return customerSalary;
    }

    public ArrayList getContactNumber() {
        return contactNumber;
    }

    public String getNic() {
        return nic;
    }

    public boolean isActiveState() {
        return activeState;
    }

    //Create setters
    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public void setCustomerSalary(double customerSalary) {
        this.customerSalary = customerSalary;
    }

    public void setContactNumber(ArrayList contactNumber) {
        this.contactNumber = contactNumber;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public void setActiveState(boolean activeState) {
        this.activeState = activeState;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId=" + customerId +
                ", customerName='" + customerName + '\'' +
                ", customerAddress='" + customerAddress + '\'' +
                ", customerSalary=" + customerSalary +
                ", contactNumber=" + contactNumber +
                ", nic='" + nic + '\'' +
                ", activeState=" + activeState +
                '}';
    }

}
