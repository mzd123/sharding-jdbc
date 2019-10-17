package com.tuesdayma.mysharding.dao;

import com.tuesdayma.mysharding.model.Person;
import com.tuesdayma.mysharding.model.PersonExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
public interface PersonMapper {
    long countByExample(PersonExample example);

    int deleteByExample(PersonExample example);

    int insert(Person record);

    int insertSelective(Person record);

    List<Person> selectByExample(PersonExample example);

    int updateByExampleSelective(@Param("record") Person record, @Param("example") PersonExample example);

    int updateByExample(@Param("record") Person record, @Param("example") PersonExample example);
}