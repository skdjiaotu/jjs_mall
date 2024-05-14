package com.example.eurekaconsumer.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
public class PurchaseRefundData {
    String orderSn;
    Integer dayRefundGoodsNumber30;
    Integer dayRefundGoodsNumber60;
    Integer dayRefundGoodsNumber90;
}
