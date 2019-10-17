package com.tuesdayma.mysharding.dao;

import com.tuesdayma.mysharding.dto.PersonDTO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
public interface PersonExtMapper extends PersonMapper {
    public PersonDTO selectAll(@Param("id") Long id, @Param("age") int age);
}