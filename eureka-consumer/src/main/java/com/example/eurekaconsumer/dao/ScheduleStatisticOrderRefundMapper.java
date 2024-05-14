package com.example.eurekaconsumer.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.eurekaconsumer.dto.DispatchRefundData;
import com.example.eurekaconsumer.dto.DispatchShipmentData;
import com.example.eurekaconsumer.dto.PurchaseRefundData;
import com.example.eurekaconsumer.dto.PurchaseShipmentData;
import com.example.eurekaconsumer.entity.ScheduleStatisticOrderGoods;
import com.example.eurekaconsumer.entity.ScheduleStatisticOrderRefund;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * (ScheduleStatisticOrderRefund)表数据库访问层
 *
 * @author makejava
 * @since 2024-01-18 17:19:14
 */
@Mapper
public interface ScheduleStatisticOrderRefundMapper  extends BaseMapper<ScheduleStatisticOrderRefund> {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    ScheduleStatisticOrderRefund queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param scheduleStatisticOrderRefund 查询条件
     * @return 对象列表
     */
    List<ScheduleStatisticOrderRefund> queryAllByLimit(@Param("orderRefund") ScheduleStatisticOrderRefund scheduleStatisticOrderRefund,  @Param("page")  int page, @Param("pageSize")  int pageSize);

    /**
     * 统计总行数
     *
     * @param scheduleStatisticOrderRefund 查询条件
     * @return 总行数
     */
    long count(ScheduleStatisticOrderRefund scheduleStatisticOrderRefund);

    /**
     * 新增数据
     *
     * @param scheduleStatisticOrderRefund 实例对象
     * @return 影响行数
     */
    int insert(ScheduleStatisticOrderRefund scheduleStatisticOrderRefund);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<ScheduleStatisticOrderRefund> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<ScheduleStatisticOrderRefund> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<ScheduleStatisticOrderRefund> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<ScheduleStatisticOrderRefund> entities);

    /**
     * 修改数据
     *
     * @param scheduleStatisticOrderRefund 实例对象
     * @return 影响行数
     */
    int update(ScheduleStatisticOrderRefund scheduleStatisticOrderRefund);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

    List<PurchaseRefundData> getPurchaseRefundData(@Param("startTime") Date startTime,
                                                        @Param("endTime") Date endTime);


    List<DispatchRefundData> getDispatchRefundData(@Param("startTime") Date startTime,
                                                   @Param("endTime") Date endTime);


}

