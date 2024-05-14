package com.example.eurekaconsumer.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.eurekaconsumer.dto.DispatchShipmentData;
import com.example.eurekaconsumer.dto.PurchaseShipmentData;
import com.example.eurekaconsumer.entity.ScheduleStatisticOrderGoods;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

@Mapper
public interface ScheduleStatisticOrderGoodsMapper extends BaseMapper<ScheduleStatisticOrderGoods> {
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    ScheduleStatisticOrderGoods queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param scheduleStatisticOrderGoods 查询条件
     * @param page         第几页
     * @param pageSize     每页多少
     * @return 对象列表
     */
    List<ScheduleStatisticOrderGoods> queryAllByLimit(@Param("scheduleStatisticOrderGoods") ScheduleStatisticOrderGoods scheduleStatisticOrderGoods, @Param("page")  int page, @Param("pageSize")  int pageSize);

    /**
     * 统计总行数
     *
     * @param scheduleStatisticOrderGoods 查询条件
     * @return 总行数
     */
    long count(ScheduleStatisticOrderGoods scheduleStatisticOrderGoods);

    /**
     * 新增数据
     *
     * @param scheduleStatisticOrderGoods 实例对象
     * @return 影响行数
     */
    int insert(ScheduleStatisticOrderGoods scheduleStatisticOrderGoods);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<ScheduleStatisticOrderGoods> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<ScheduleStatisticOrderGoods> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<ScheduleStatisticOrderGoods> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<ScheduleStatisticOrderGoods> entities);

    /**
     * 修改数据
     *
     * @param scheduleStatisticOrderGoods 实例对象
     * @return 影响行数
     */
    int update(ScheduleStatisticOrderGoods scheduleStatisticOrderGoods);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);


    List<PurchaseShipmentData> getPurchaseShipmentData(@Param("startTime") Date startTime,
                                                       @Param("endTime") Date endTime);


    List<DispatchShipmentData> getDispatchOrderShipmentData(@Param("startTime") Date startTime,
                                                            @Param("endTime") Date endTime);

}
