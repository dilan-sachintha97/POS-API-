package com.batch80.pointofsalebatch80.dto.request;

import com.batch80.pointofsalebatch80.entity.enums.MeasuringUintType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RequestSaveItemDTO {
    private  String itemName;
    //private String measuringUnit;
    private MeasuringUintType measuringUnit;
    private double balanceQty;
    private double supplierPrice;
    private double sellingPrice;
}
