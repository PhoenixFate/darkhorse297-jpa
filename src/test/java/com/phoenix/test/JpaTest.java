package com.phoenix.test;

import com.phoenix.pojo.Customer;
import org.junit.Test;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;


public class JpaTest {
    /**
     * 测试jpa的保存
     * jpa的操作步骤
     *    1.加载配置文件创建工厂（实体管理器工厂）对象
     *    2.通过实体管理器工厂获取实体管理器
     *    3.获取事物对象，开启事务
     *    4.完成增删改查操作
     *    5.提交事务（回滚事务）
     *    6.释放资源
     */
    @Test
    public void testSave(){
        //1.加载配置文件创建工厂（实体管理器工厂）对象
        //persistenceUnitName 就是persistence.xml中配置的name
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myJpa");
        //2.通过实体管理器工厂获取实体管理器
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        //3.获取事物对象，开启事务
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        Customer customer=new Customer();
        customer.setCustName("tomcat");
        customer.setCustIndustry("it");
        //4.完成增删改查操作
        entityManager.persist(customer);//保存操作
        //5.提交事务（回滚事务）
        transaction.commit();
        //6.释放资源
        entityManager.clear();
        entityManagerFactory.close();
    }

}
