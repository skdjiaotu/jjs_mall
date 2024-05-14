package com.example.eurekaconsumer.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.eurekaconsumer.common.CommonResult;
import com.example.eurekaconsumer.dto.UsersLoginParam;
import com.example.eurekaconsumer.entity.Users;
import com.example.eurekaconsumer.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * (Users)表控制层
 *
 * @author makejava
 * @since 2024-05-10 17:41:51
 */
@RestController
@RequestMapping("users")
public class UsersController {
    @Value("${jwt.tokenHeader}")
    private String tokenHeader;
    @Value("${jwt.tokenHead}")
    private String tokenHead;
    /**
     * 服务对象
     */
    @Autowired
    private LoginService usersService;

    /**
     * 分页查询所有数据
     *
     * @param page  分页对象
     * @param users 查询实体
     * @return 所有数据
     */
    @GetMapping
    @ResponseBody
    public CommonResult<IPage<Users>> selectAll(Page<Users> page, Users users) {
        return CommonResult.success(this.usersService.page(page, new QueryWrapper<>(users)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/user/{id}")
    @ResponseBody
    public CommonResult<Users> selectOne(@PathVariable Integer id) {
        System.out.println("====================");
        System.out.println(id);
        return CommonResult.success(this.usersService.getById(id));
    }
    @GetMapping("/user/loginPage")
    @ResponseBody
    public CommonResult<Users> loginPage(@PathVariable Serializable id) {
        System.out.println("====================");
        System.out.println(id);
        return CommonResult.success(this.usersService.getById(id));
    }

    @PostMapping("/login")
    @ResponseBody
    public CommonResult login(@Validated @RequestBody Users users) {
        String token = usersService.login(users);
        if (token == null) {
            return CommonResult.validateFailed("用户名或密码错误");
        }
        Map<String, String> tokenMap = new HashMap<>();
        tokenMap.put("token", token);
        tokenMap.put("tokenHead", tokenHead);
        return CommonResult.success(tokenMap);
    }


    /**
     * 新增数据
     *
     * @param users 实体对象
     * @return 新增结果
     */
    @PostMapping
    @ResponseBody
    public CommonResult<Boolean> insert(@RequestBody Users users) {
        return CommonResult.success(this.usersService.save(users));
    }

    /**
     * 修改数据
     *
     * @param users 实体对象
     * @return 修改结果
     */
    @PutMapping
    @ResponseBody
    public CommonResult<Boolean> update(@RequestBody Users users) {
        return CommonResult.success(this.usersService.updateById(users));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    @ResponseBody
    public CommonResult<Boolean> delete(@RequestParam("idList") List<Long> idList) {
        return CommonResult.success(this.usersService.removeByIds(idList));
    }
}

