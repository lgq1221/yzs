package com.statistics.yzs.jpa;

import com.statistics.yzs.entity.SysUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.io.Serializable;

/**
 * @author Lgq
 * @Desc
 * @create 2019-01-15 14:10
 * UserJPA继承了JpaRepository接口（SpringDataJPA提供的简单数据操作接口）、
 * JpaSpecificationExecutor（SpringDataJPA提供的复杂查询接口）、
 * Serializable（序列化接口）.
 * SpringDataJPA内部使用了类代理的方式让继承了它接口的子接口都以spring管理的Bean的形式存在
 **/
public interface SysUserJPA extends JpaRepository<SysUserEntity,Long>,
        JpaSpecificationExecutor<SysUserEntity>,Serializable {
}
