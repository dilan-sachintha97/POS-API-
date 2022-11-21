package com.batch80.pointofsalebatch80.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ResponseActiveCustomerDTO {
    private String customerName;
    private ArrayList contactNumber;
}
