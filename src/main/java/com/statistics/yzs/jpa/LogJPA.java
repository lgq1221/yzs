package com.statistics.yzs.jpa;

import com.statistics.yzs.entity.LogEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Lgq
 * @Desc
 * @create 2019-04-25 11:23
 **/
public interface LogJPA extends JpaRepository<LogEntity,Long>{

}
