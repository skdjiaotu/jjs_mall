package com.example.eurekaconsumer.dao;

import java.io.Serializable;
import java.util.List;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.example.eurekaconsumer.entity.Users;
import org.apache.ibatis.annotations.Select;

/**
 * (Users)表数据库访问层
 *
 * @author makejava
 * @since 2024-05-10 17:41:51
 */
@Mapper
public interface UsersMapper extends BaseMapper<Users> {

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Users> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Users> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Users> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<Users> entities);

    @Select("select * from users where username=#{name}")
    Users loadUserByUsername(@Param("name") String name);
}

