package com.example.eurekaconsumer.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;
import java.io.Serializable;

/**
 * (ScheduleStatisticOrderRefund)实体类
 *
 * @author makejava
 * @since 2024-01-18 17:19:14
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("schedule_statistic_order_refund")
public class ScheduleStatisticOrderRefund extends Model<ScheduleStatisticOrderGoods> {

    private Integer id;
    /**
     * 退款详情id
     */
    private String refundDetailId;
    /**
     * 订单id
     */
    private Integer orderId;
    /**
     * 退款id
     */
    private String refundId;
    /**
     * 品类
     */
    private Integer externalCatId;
    /**
     * 品类
     */
    private Integer externalGoodsId;

    private String goodsSize;

    private String goodsColor;

    private String orderSn;

    private String uniqSku;

    private String taobaoOrderSn;

    private Date refundCreateStamp;

    private Date refundExecuteDate;
    /**
     * 一级退款原因
     */
    private String level1Reason;
    /**
     * 二级退款原因
     */
    private String level2Reason;
    /**
     * 三级退款原因
     */
    private String level3Reason;
    /**
     * 退款部门类型,处于哪一个部门审核
     */
    private String refundDepType;

    private Double refundAmount;

    private String refundOrderStatus;

    private String regionName;

    private Date orderTime;

    private Date shippingTime;

    private String orderGoodsId;

    private Integer isDispatch;

    private Integer refundGoodsNumber;

    private String hasImage;
    /**
     * 退款类型
     */
    private String refundType;
    /**
     * 售卖商品对应的供应商
     */
    private Integer providerId;
    /**
     * 工单号或者是采购单号
     */
    private String purchaseSn;
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

    private Integer sourceId;
    /**
     * 货币
     */
    private String currency;
    /**
     * 商品单价
     */
    private Double goodsPrice;
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

