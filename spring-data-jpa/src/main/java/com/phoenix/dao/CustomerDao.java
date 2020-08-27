package com.phoenix.dao;

import com.phoenix.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * SpringDataJpa dao层的接口规范
 *      继承两个接口：
 *          JpaRepository<操作的实体类，实体类主键类型>
 *              封装类crud基本操作
 *          JpaSpecificationExecutor<操作的实体类>
 *              封装类复杂查询：分页等
 */
public interface CustomerDao extends JpaRepository<Customer,Long>, JpaSpecificationExecutor<Customer> {



}
