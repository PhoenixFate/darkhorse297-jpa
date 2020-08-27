package com.phoenix.test;

import com.phoenix.dao.CustomerDao;
import com.phoenix.domain.Customer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class) //声明spring提供的单元测试环境
@ContextConfiguration(locations = "classpath:applicationContext.xml")  //指定spring容器的配置信息
public class CustomerTest {

    @Autowired
    private CustomerDao customerDao;

    @Test
    public void TestFindAll(){
        List<Customer> customerList = customerDao.findAll();
        for(Customer customer:customerList){
            System.out.println(customer);
        }
    }

    @Test
    public void TestFindOne(){
        Customer one = customerDao.findOne(2l);
        System.out.println(one);
    }



}
