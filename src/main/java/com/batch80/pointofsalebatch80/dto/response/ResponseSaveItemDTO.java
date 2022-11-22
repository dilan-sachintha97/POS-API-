package com.batch80.pointofsalebatch80.dto.response;
import com.batch80.pointofsalebatch80.entity.enums.MeasuringUintType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ResponseSaveItemDTO {
    private int itemId;
    private  String itemName;
    private MeasuringUintType measuringUnit;
    private double balanceQty;
    private double supplierPrice;
    private double sellingPrice;
    private boolean activeState;
}
