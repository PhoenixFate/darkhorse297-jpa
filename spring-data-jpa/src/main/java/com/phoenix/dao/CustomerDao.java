package com.phoenix.dao;

import com.phoenix.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

/**
 * SpringDataJpa dao层的接口规范
 *      继承两个接口：
 *          JpaRepository<操作的实体类，实体类主键类型>
 *              封装类crud基本操作
 *          JpaSpecificationExecutor<操作的实体类>
 *              封装类复杂查询：分页等
 */
public interface CustomerDao extends JpaRepository<Customer,Long>, JpaSpecificationExecutor<Customer> {


    /**
     * 使用jpql需要将jpaql语句配置到接口方法上
     *      1.特有的查询：需要在dao接口上配置方法
     *      2.在新添加的方法上，使用注解的形式配置jpql查询语句
     *      3.注解：@Query
     * jpql: from Customer where custName = ?
     */
    @Query(value = "from Customer where custName = ?1")
    Customer findByNameByJpql(String name);

    /**
     * 对于多个占位符参数
     *      赋值的时候，默认的情况下，占位符的位置需要和方法参数中的位置保持一致
     * 可以指定占位符参数的位置
     *      ？ 索引的方式，指定此占位的取值来源
     * @param name
     * @param id
     * @return
     */
    @Query("from Customer where custName = ?1 and custId=?2")
    Customer findByNameAndIdByJpql(String name,Long id);


    /**
     * jpql update
     *
     * @Query声明当前sql、jpql是一个查询操作
     * @Modifying声明当前sql、jpql是一个更新操作
     *
     * @param name
     * @param id
     */
    @Query("update Customer set custName=?1 where custId=?2")
    @Modifying
    void updateCustomerName(String name,Long id);

}
