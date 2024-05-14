package com.example.eurekaconsumer.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

@Data
@EqualsAndHashCode
public class DispatchShipmentD30Data {
    Integer externalGoodsId;
    Integer externalCatId;
    Integer goodsPartyId;
    Integer providerId;
    String orderSn;
    String dispatchSn;
    String stockSequence;
    Date createTime;
    Integer quantity;
    String requestStatus;
    Date inTime;
    Integer inQuantity;
    String providerCode;
    Integer dayShipmentNum30;
    Integer dayShipmentNum30T60;
    Integer dayShipmentNum60T90;
    Integer dayRefundNum30;
    Integer dayRefundNum30T60;
    Integer dayRefundNum60T90;
}
