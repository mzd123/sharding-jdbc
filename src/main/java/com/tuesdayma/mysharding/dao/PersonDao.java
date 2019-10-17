package com.tuesdayma.mysharding.dao;

import com.tuesdayma.mysharding.bean.Person;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author: mzd
 * @Date: 2019/10/16 11:06
 */
@Component
@MapperScan
public interface PersonDao {
    @Insert("insert into person (name,age) values(#{name},#{age})")
    void doinsert(@Param("name") String name, @Param("age") int age);


    @Insert("insert into person (name,age,sex) values(#{name},#{age},#{sex})")
    void doinsert1(@Param("name") String name, @Param("age") int age, @Param("sex") int sex);

    @Select("select * from  person where id =#{id}")
    @Results(value = {
            @Result(id = true, property = "id", column = "id", javaType = Long.class, jdbcType = JdbcType.BIGINT),
            @Result(property = "name", column = "name", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(property = "age", column = "age", javaType = Integer.class, jdbcType = JdbcType.INTEGER),
            @Result(property = "sex", column = "sex", javaType = Integer.class, jdbcType = JdbcType.INTEGER)
    })
    Person select(@Param("id") Long id);


    @Select("select * from  person where id =#{id} and age=#{age}")
    @Results(value = {
            @Result(id = true, property = "id", column = "id", javaType = Long.class, jdbcType = JdbcType.BIGINT),
            @Result(property = "name", column = "name", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(property = "age", column = "age", javaType = Integer.class, jdbcType = JdbcType.INTEGER),
            @Result(property = "sex", column = "sex", javaType = Integer.class, jdbcType = JdbcType.INTEGER)
    })
    Person selectByIdAndUserid(@Param("id") Long id, @Param("age") int age);


    @Select("select * from  person order by id limit 10")
    @Results(value = {
            @Result(id = true, property = "id", column = "id", javaType = Long.class, jdbcType = JdbcType.BIGINT),
            @Result(property = "name", column = "name", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(property = "age", column = "age", javaType = Integer.class, jdbcType = JdbcType.INTEGER),
            @Result(property = "sex", column = "sex", javaType = Integer.class, jdbcType = JdbcType.INTEGER)
    })
    List<Person> selectOrderByid();
}
