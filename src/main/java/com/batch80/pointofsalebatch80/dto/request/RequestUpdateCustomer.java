package com.batch80.pointofsalebatch80.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RequestUpdateCustomer {
    private String customerName;
    private String customerAddress;
    private double customerSalary;
}
