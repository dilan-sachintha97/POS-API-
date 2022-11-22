package com.batch80.pointofsalebatch80.entity;

import com.batch80.pointofsalebatch80.entity.enums.MeasuringUintType;
import com.vladmihalcea.hibernate.type.json.JsonType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import javax.persistence.*;

@Entity
@Table(name = "item")

@TypeDefs({
        @TypeDef(name = "json", typeClass = JsonType.class)
})

@AllArgsConstructor
@NoArgsConstructor
@Data  // setters getters toString()
public class Item {
    @Id
    @Column(name ="item_id",length = 30)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int itemId;

    @Column(name ="item_name",length = 60, nullable = false)
    private  String itemName;

    @Enumerated(EnumType.STRING)
    @Column(name ="measuring_unit",length = 35, nullable = false)
    private MeasuringUintType measuringUnit;

    @Column(name ="balance_qty",length = 20, nullable = false)
    private double balanceQty;

    @Column(name ="supplier_price",length = 20, nullable = false)
    private double supplierPrice;

    @Column(name ="selling_price",length = 20, nullable = false)
    private double sellingPrice;

    @Column(name = "active_state", columnDefinition = "TINYINT default 1")
    private boolean activeState;


}
