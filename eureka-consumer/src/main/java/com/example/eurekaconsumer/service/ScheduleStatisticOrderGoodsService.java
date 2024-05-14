package com.example.eurekaconsumer.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.eurekaconsumer.dto.*;
import com.example.eurekaconsumer.entity.ScheduleStatisticOrderGoods;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;


public interface ScheduleStatisticOrderGoodsService extends IService<ScheduleStatisticOrderGoods> {
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    ScheduleStatisticOrderGoods queryById(Integer id);


    List<PurchaseShipmentData> getPurchaseShipmentData(Date startTime, Date endTime);


    List<DispatchShipmentData> getDispatchShipmentData(Date startTime, Date endTime);


    List<PurchaseRefundData> getPurchaseRefundData(Date startTime, Date endTime);


    List<DispatchRefundData> getDispatchRefundData(Date startTime, Date endTime);
    /**
     * 分页查询
     *
     * @param scheduleStatisticOrderGoods 筛选条件
     * @return 查询结果
     */
    List<ScheduleStatisticOrderGoods> queryByPage(ScheduleStatisticOrderGoods scheduleStatisticOrderGoods, int page, int pageSize);

    /**
     * 新增数据
     *
     * @param scheduleStatisticOrderGoods 实例对象
     * @return 实例对象
     */
    ScheduleStatisticOrderGoods insert(ScheduleStatisticOrderGoods scheduleStatisticOrderGoods);

    /**
     * 修改数据
     *
     * @param scheduleStatisticOrderGoods 实例对象
     * @return 实例对象
     */
    ScheduleStatisticOrderGoods update(ScheduleStatisticOrderGoods scheduleStatisticOrderGoods);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

    List<PurchaseShipmentD30Data> getSummaryData(Date startDay, Date endDay);
}
