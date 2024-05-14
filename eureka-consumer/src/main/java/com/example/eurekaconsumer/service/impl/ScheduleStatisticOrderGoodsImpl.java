package com.example.eurekaconsumer.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.eurekaconsumer.dto.*;
import com.example.eurekaconsumer.entity.ScheduleStatisticOrderGoods;
import com.example.eurekaconsumer.dao.ScheduleStatisticOrderGoodsMapper;
import com.example.eurekaconsumer.dao.ScheduleStatisticOrderRefundMapper;
import com.example.eurekaconsumer.service.ScheduleStatisticOrderGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class ScheduleStatisticOrderGoodsImpl
        extends ServiceImpl<ScheduleStatisticOrderGoodsMapper, ScheduleStatisticOrderGoods> implements ScheduleStatisticOrderGoodsService {

    @Autowired
    private ScheduleStatisticOrderGoodsMapper scheduleStatisticOrderGoodsMapper;
    @Autowired
    private ScheduleStatisticOrderRefundMapper scheduleStatisticOrderRefundMapper;

    @Override
    public ScheduleStatisticOrderGoods queryById(Integer id) {
        return scheduleStatisticOrderGoodsMapper.selectById(id);
    }

    @Override
    public List<PurchaseShipmentData> getPurchaseShipmentData(Date startTime, Date endTime) {
        return scheduleStatisticOrderGoodsMapper.getPurchaseShipmentData(startTime, endTime);
    }

    @Override
    public List<DispatchShipmentData> getDispatchShipmentData(Date startTime, Date endTime) {
        return scheduleStatisticOrderGoodsMapper.getDispatchOrderShipmentData(startTime, endTime);
    }

    @Override
    public List<PurchaseRefundData> getPurchaseRefundData(Date startTime, Date endTime) {
        return scheduleStatisticOrderRefundMapper.getPurchaseRefundData(startTime, endTime);
    }

    @Override
    public List<DispatchRefundData> getDispatchRefundData(Date startTime, Date endTime) {
        return scheduleStatisticOrderRefundMapper.getDispatchRefundData(startTime, endTime);
    }

    /**
     * 分页查询
     *
     * @param scheduleStatisticOrderGoods 筛选条件
     * @param page                        第几页
     * @param pageSize                    每页多少
     * @return 查询结果
     */
    @Override
    public List<ScheduleStatisticOrderGoods> queryByPage(ScheduleStatisticOrderGoods scheduleStatisticOrderGoods, int page, int pageSize) {
        return this.scheduleStatisticOrderGoodsMapper.queryAllByLimit(scheduleStatisticOrderGoods, page, pageSize);
    }

    /**
     * 新增数据
     *
     * @param scheduleStatisticOrderGoods 实例对象
     * @return 实例对象
     */
    @Override
    public ScheduleStatisticOrderGoods insert(ScheduleStatisticOrderGoods scheduleStatisticOrderGoods) {
        this.scheduleStatisticOrderGoodsMapper.insert(scheduleStatisticOrderGoods);
        return scheduleStatisticOrderGoods;
    }

    /**
     * 修改数据
     *
     * @param scheduleStatisticOrderGoods 实例对象
     * @return 实例对象
     */
    @Override
    public ScheduleStatisticOrderGoods update(ScheduleStatisticOrderGoods scheduleStatisticOrderGoods) {
        this.scheduleStatisticOrderGoodsMapper.update(scheduleStatisticOrderGoods);
        return this.queryById(scheduleStatisticOrderGoods.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.scheduleStatisticOrderGoodsMapper.deleteById(id) > 0;
    }

    @Override
    public List<PurchaseShipmentD30Data> getSummaryData(Date startDay, Date endDay) {
        List<PurchaseShipmentData> purchaseShipmentData = getPurchaseShipmentData(startDay, endDay);
        List<DispatchShipmentData> dispatchShipmentData = getDispatchShipmentData(startDay, endDay);
        List<PurchaseRefundData> purchaseRefundData = getPurchaseRefundData(startDay, endDay);
        List<DispatchRefundData> dispatchRefundData = getDispatchRefundData(startDay, endDay);
        Map<String, PurchaseRefundData> collectPurchase = purchaseRefundData.stream().collect(Collectors.toMap(PurchaseRefundData::getOrderSn, Function.identity()));
        Map<String, DispatchRefundData> collectDispatch = dispatchRefundData.stream().collect(Collectors.toMap(DispatchRefundData::getDispatchSn, Function.identity()));

        List<PurchaseShipmentD30Data> purchaseShipmentD30DataList = new ArrayList<>();
        for (PurchaseShipmentData object : purchaseShipmentData) {
            PurchaseShipmentD30Data purchaseShipmentD30Data = new PurchaseShipmentD30Data();
            purchaseShipmentD30Data.setExternalGoodsId(object.getExternalGoodsId());
            purchaseShipmentD30Data.setExternalCatId(object.getExternalCatId());
            purchaseShipmentD30Data.setGoodsPartyId(object.getGoodsPartyId());
            purchaseShipmentD30Data.setProviderId(object.getProviderId());
            purchaseShipmentD30Data.setOrderSn(object.getOrderSn());
            purchaseShipmentD30Data.setStockSequence(object.getStockSequence());
            purchaseShipmentD30Data.setCreateTime(object.getCreateTime());
            purchaseShipmentD30Data.setQuantity(object.getQuantity());
            purchaseShipmentD30Data.setRequestStatus(object.getRequestStatus());
            purchaseShipmentD30Data.setInTime(object.getInTime());
            purchaseShipmentD30Data.setInQuantity(object.getInQuantity());
            purchaseShipmentD30Data.setProviderCode(object.getProviderCode());
            purchaseShipmentD30Data.setDayShipmentNum30(object.getDayShipmentNum30());
            purchaseShipmentD30Data.setDayShipmentNum30T60(object.getDayShipmentNum60() - object.getDayShipmentNum30());
            purchaseShipmentD30Data.setDayShipmentNum60T90(object.getDayShipmentNum90() - object.getDayShipmentNum60());
            purchaseShipmentD30Data.setDayRefundNum30(0);
            purchaseShipmentD30Data.setDayRefundNum30T60(0);
            purchaseShipmentD30Data.setDayRefundNum60T90(0);

            if (collectPurchase.containsKey(object.getOrderSn())) {
                PurchaseRefundData refundData = collectPurchase.get(object.getOrderSn());
                purchaseShipmentD30Data.setDayRefundNum30(refundData.getDayRefundGoodsNumber30());
                purchaseShipmentD30Data.setDayRefundNum30T60(refundData.getDayRefundGoodsNumber60() - refundData.getDayRefundGoodsNumber30());
                purchaseShipmentD30Data.setDayRefundNum60T90(refundData.getDayRefundGoodsNumber90() - refundData.getDayRefundGoodsNumber60());
            }
            purchaseShipmentD30DataList.add(purchaseShipmentD30Data);
        }

        List<DispatchShipmentD30Data> dispatchShipmentD30DataList = new ArrayList<>();
        for (DispatchShipmentData object : dispatchShipmentData) {
            DispatchShipmentD30Data dispatchShipmentD30Data = new DispatchShipmentD30Data();
            dispatchShipmentD30Data.setExternalGoodsId(object.getExternalGoodsId());
            dispatchShipmentD30Data.setExternalCatId(object.getExternalCatId());
            dispatchShipmentD30Data.setGoodsPartyId(object.getGoodsPartyId());
            dispatchShipmentD30Data.setProviderId(object.getProviderId());
            dispatchShipmentD30Data.setOrderSn(object.getOrderSn());
            dispatchShipmentD30Data.setStockSequence(object.getStockSequence());
            dispatchShipmentD30Data.setCreateTime(object.getCreateTime());
            dispatchShipmentD30Data.setQuantity(object.getQuantity());
            dispatchShipmentD30Data.setRequestStatus(object.getRequestStatus());
            dispatchShipmentD30Data.setInTime(object.getInTime());
            dispatchShipmentD30Data.setInQuantity(object.getInQuantity());
            dispatchShipmentD30Data.setProviderCode(object.getProviderCode());
            dispatchShipmentD30Data.setDayShipmentNum30(object.getDayShipmentNum30());
            dispatchShipmentD30Data.setDayShipmentNum30T60(object.getDayShipmentNum60());
            dispatchShipmentD30Data.setDayShipmentNum60T90(object.getDayShipmentNum90());
            dispatchShipmentD30Data.setDayRefundNum30(0);
            dispatchShipmentD30Data.setDayRefundNum30T60(0);
            dispatchShipmentD30Data.setDayRefundNum60T90(0);

            if (collectPurchase.containsKey(object.getOrderSn())) {
                PurchaseRefundData refundData = collectPurchase.get(object.getOrderSn());
                dispatchShipmentD30Data.setDayRefundNum30(refundData.getDayRefundGoodsNumber30());
                dispatchShipmentD30Data.setDayRefundNum30T60(refundData.getDayRefundGoodsNumber60());
                dispatchShipmentD30Data.setDayRefundNum60T90(refundData.getDayRefundGoodsNumber90());
            }
            dispatchShipmentD30DataList.add(dispatchShipmentD30Data);
        }
        dispatchShipmentD30DataList.stream()
                .collect(Collectors.groupingBy(DispatchShipmentD30Data::getOrderSn,Collectors.toList()));

        return purchaseShipmentD30DataList;
    }


}
