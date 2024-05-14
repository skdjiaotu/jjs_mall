package com.example.eurekaconsumer.controller;

import com.example.eurekaconsumer.dto.*;
import com.example.eurekaconsumer.entity.ScheduleStatisticOrderGoods;
import com.example.eurekaconsumer.event.UserServiceImpl;
import com.example.eurekaconsumer.service.ScheduleStatisticOrderGoodsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * (ScheduleStatisticOrderGoods)表控制层
 *
 * @author makejava
 * @since 2024-01-16 17:44:25
 */
@RestController
@RequestMapping("scheduleStatisticOrderGoods")
public class ScheduleStatisticOrderGoodsController {
    /**
     * 服务对象
     */
    @Autowired
    private ScheduleStatisticOrderGoodsService scheduleStatisticOrderGoodsService;

    @Autowired
    private UserServiceImpl userService;
    @Autowired
    private  final RedisTemplate redisTemplate;

    private Integer myId = 0;


    private static final Logger logger = LoggerFactory.getLogger(ScheduleStatisticOrderGoodsController.class);

    public ScheduleStatisticOrderGoodsController(RedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }


    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<ScheduleStatisticOrderGoods> queryById(@PathVariable("id") Integer id) {
        System.out.println(id);
        return ResponseEntity.ok(this.scheduleStatisticOrderGoodsService.queryById(id));
    }

    /**
     * 通过主键查询单条数据
     *
     * @return 单条数据
     */
    @RequestMapping(value = "/getLog", method = RequestMethod.GET)
    public ResponseEntity<String> getLog() {
        logger.trace("A TRACE Message");
        logger.debug("A DEBUG Message");
        logger.info("An INFO Message");
        logger.warn("A WARN Message");
        logger.error("An ERROR Message");

        //redisTemplate.opsForValue().set("key", "value1");

        redisTemplate.opsForList().rightPush("cart", "name");
        redisTemplate.opsForList().rightPush("cart", "name");

        return ResponseEntity.ok("获取日志成功");
    }

    /**
     * 分页查询
     *
     * @param scheduleStatisticOrderGoods 筛选条件
     * @return 查询结果
     */
    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public ResponseEntity<List<ScheduleStatisticOrderGoods>> queryByPage(ScheduleStatisticOrderGoods scheduleStatisticOrderGoods,
                                                                         @RequestParam(required = false, defaultValue = "1") Integer pageNum,
                                                                         @RequestParam(required = false, defaultValue = "5") Integer pageSize) {
        System.out.println(scheduleStatisticOrderGoods);
        System.out.println(pageNum);
        System.out.println(pageSize);
        return ResponseEntity.ok(this.scheduleStatisticOrderGoodsService.queryByPage(scheduleStatisticOrderGoods, pageNum, pageSize));
    }

    @RequestMapping(value = "/purchaseShipmentData", method = RequestMethod.GET)
    public ResponseEntity<List<PurchaseShipmentData>> getPurchaseShipmentData(@RequestParam(required = true) String startTime,
                                                                              @RequestParam(required = true) String endTime) throws ParseException {
        System.out.println(startTime);
        System.out.println(endTime);
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date startDay = dateFormat.parse(startTime);
        Date endDay = dateFormat.parse(endTime);
        return ResponseEntity.ok(this.scheduleStatisticOrderGoodsService.getPurchaseShipmentData( startDay, endDay));
    }

    @RequestMapping(value = "/dispatchShipmentData", method = RequestMethod.GET)
    public ResponseEntity<List<DispatchShipmentData>> getDispatchShipmentData(@RequestParam(required = true) String startTime,
                                                                              @RequestParam(required = true) String endTime) throws ParseException {
        System.out.println(startTime);
        System.out.println(endTime);
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date startDay = dateFormat.parse(startTime);
        Date endDay = dateFormat.parse(endTime);
        return ResponseEntity.ok(this.scheduleStatisticOrderGoodsService.getDispatchShipmentData( startDay, endDay));
    }

    @RequestMapping(value = "/purchaseRefundData", method = RequestMethod.GET)
    public ResponseEntity<List<PurchaseRefundData>> getPurchaseRefundData(@RequestParam(required = true) String startTime,
                                                                               @RequestParam(required = true) String endTime) throws ParseException {
        System.out.println(startTime);
        System.out.println(endTime);
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date startDay = dateFormat.parse(startTime);
        Date endDay = dateFormat.parse(endTime);
        return ResponseEntity.ok(this.scheduleStatisticOrderGoodsService.getPurchaseRefundData( startDay, endDay));
    }

    @RequestMapping(value = "/dispatchRefundData", method = RequestMethod.GET)
    public ResponseEntity<List<DispatchRefundData>> getDispatchRefundData(@RequestParam(required = true) String startTime,
                                                                          @RequestParam(required = true) String endTime) throws ParseException {
        System.out.println(startTime);
        System.out.println(endTime);
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date startDay = dateFormat.parse(startTime);
        Date endDay = dateFormat.parse(endTime);
        return ResponseEntity.ok(this.scheduleStatisticOrderGoodsService.getDispatchRefundData( startDay, endDay));
    }

    @RequestMapping(value = "/getSummaryData", method = RequestMethod.GET)
    public ResponseEntity<List<PurchaseShipmentD30Data>> getSummaryData(@RequestParam(required = true) String startTime,
                                                                        @RequestParam(required = true) String endTime) throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date startDay = dateFormat.parse(startTime);
        Date endDay = dateFormat.parse(endTime);

        return ResponseEntity.ok(this.scheduleStatisticOrderGoodsService.getSummaryData( startDay, endDay));
    }

}

