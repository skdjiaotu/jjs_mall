package com.example.eurekaconsumer.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Data
@TableName("schedule_statistic_order_goods")
public class ScheduleStatisticOrderGoods extends Model<ScheduleStatisticOrderGoods>  {
    private Integer id;

    private Integer orderId;

    private String orderGoodsId;
    /**
     * 工单号或者是采购单号
     */
    private String purchaseSn;

    private String taobaoOrderSn;

    private Date shippingTime;

    private String goodsSize;

    private String goodsColor;

    private String uniqSku;

    private Integer externalGoodsId;

    private Integer externalCatId;

    private Integer goodsNumber;
    /**
     * 商品单价
     */
    private Double goodsPrice;
    /**
     * 下单地区
     */
    private String regionName;
    /**
     * 商品款式
     */
    private Integer sourceId;
    /**
     * 订单下单时间
     */
    private Date orderTime;
    /**
     * 售卖商品对应的供应商
     */
    private Integer providerId;
    /**
     * 是不是工单
     */
    private Integer isDispatch;
    /**
     * 仓库id
     */
    private String facilityId;
    /**
     * 组织
     */
    private String partyId;
    /**
     * 来源网站
     */
    private String fromDomain;
    /**
     * 货币
     */
    private String currency;
    /**
     * 国家id
     */
    private Integer regionId;

    private Integer isNewGoods;
    /**
     * 邮箱
     */
    private String email;
}
