package com.tuesdayma.mysharding;

import com.tuesdayma.mysharding.bean.Person;
import com.tuesdayma.mysharding.dao.DicMapper;
import com.tuesdayma.mysharding.dao.PersonDao;
import com.tuesdayma.mysharding.dao.PersonExtMapper;
import com.tuesdayma.mysharding.dao.PersonMapper;
import com.tuesdayma.mysharding.model.Dic;
import com.tuesdayma.mysharding.model.PersonExample;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Random;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MyshardingApplication.class)
public class MyshardingApplicationTests {
    @Autowired
    private PersonDao person;

    @Autowired
    private PersonMapper personMapper;

    @Autowired
    private DicMapper dicMapper;

    @Autowired
    private PersonExtMapper personExtMapper;

    //==============================单数据源的，即：水平分表==============================
//    //注解sql形式
//    @Test
//    public void contextLoads1() {
//        for (int i = 1; i < 20; i++) {
//            person.doinsert("小明", i);
//        }
//    }
//
//    @Test
//    public void contextLoads2() {
//        System.out.println(person.select(391191558684147713L).toString());
//    }
//
//    @Test
//    public void contextLoads3() {
//        List<PersonDTO> list = person.selectOrderByid();
//        list.forEach(person1 -> {
//            System.out.println(person1.toString()
//            );
//        });
//    }
//
//    //xml的sql形式
//    @Test
//    public void contextLoads4() {
//        PersonExample personExample = new PersonExample();
//        PersonExample.Criteria criteria = personExample.createCriteria();
//        criteria.andIdEqualTo(391191558684147713L);
//        List<com.tuesdayma.mysharding.model.PersonDTO> list = personMapper.selectByExample(personExample);
//        list.forEach(person1 -> {
//            System.out.println(person1.toString());
//        });
//    }

    //==============================单数据源的，即：水平分表==============================


    //==============================多数据源的，即：水平分库+水平分表==============================
    //注解sql形式
    @Test
    public void contextLoads7() {
        for (int i = 1; i < 20; i++) {
            Random random = new Random();
            person.doinsert1("小明", i, random.nextInt() % 2 + 1);
        }
    }

    @Test
    public void contextLoads8() {
        System.out.println(person.select(391605723353579520L).toString());
    }

    @Test
    public void contextLoads9() {
        System.out.println(person.selectByIdAndUserid(391605723353579520L, 6).toString());
    }

    @Test
    public void contextLoads10() {
        List<Person> list = person.selectOrderByid();
        list.forEach(person1 -> {
            System.out.println(person1.toString()
            );
        });
    }

    //xml的sql形式
    @Test
    public void contextLoads11() {
        PersonExample personExample = new PersonExample();
        PersonExample.Criteria criteria = personExample.createCriteria();
        criteria.andIdEqualTo(391605723353579520L);
        List<com.tuesdayma.mysharding.model.Person> list = personMapper.selectByExample(personExample);
        list.forEach(person1 -> {
            System.out.println(person1.toString());
        });
    }

    //全局表测试
    @Test
    public void contextLoads12() {
        Dic dic = new Dic();
        dic.setId(4L);
        dic.setDicName("test");
        dic.setDicType("aaa");
        dic.setDicDesc("desc");
        dicMapper.insert(dic);
    }

    @Test
    public void contextLoads13() {
        System.out.println(personExtMapper.selectAll(391605723353579520L,6));
    }


    //==============================多数据源的，即：水平分库+水平分表==============================

}
