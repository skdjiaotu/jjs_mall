package com.example.eurekaconsumer.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

@Data
@EqualsAndHashCode
public class PurchaseShipmentData {
    Integer externalGoodsId;
    Integer externalCatId;
    Integer goodsPartyId;
    Integer providerId;
    String orderSn;
    String stockSequence;
    Date createTime;
    Integer quantity;
    String requestStatus;
    Date inTime;
    Integer inQuantity;
    String providerCode;
    Integer dayShipmentNum30;
    Integer dayShipmentNum60;
    Integer dayShipmentNum90;
}
