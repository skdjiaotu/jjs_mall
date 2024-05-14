package com.example.eurekaconsumer.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

@Data
@EqualsAndHashCode
public class DispatchShipmentData {
    Integer externalGoodsId;
    Integer externalCatId;
    Integer goodsPartyId;
    Integer providerId;
    String providerCode;
    String dispatchSn;
    String orderSn;
    String stockSequence;
    Date createTime;
    Integer quantity;
    String requestStatus;
    Date inTime;
    Integer inQuantity;
    Date firstInvTime;
    Integer dayShipmentNum30;
    Integer dayShipmentNum60;
    Integer dayShipmentNum90;
}
