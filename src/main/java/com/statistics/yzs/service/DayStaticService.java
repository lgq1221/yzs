package com.statistics.yzs.service;

import com.statistics.yzs.entity.DayStaticEntity;
import com.statistics.yzs.jpa.DayStaticJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Lgq
 * @Desc
 * @create 2019-01-15 14:50
 **/
@Service
public class DayStaticService {
    @Autowired
    private DayStaticJPA dayStaticJPA;
    /**
     * 查询数据统计列表
     * @return
     */
    public List<DayStaticEntity> list(){

        return dayStaticJPA.findAll();
    }

    /**
     * 添加、更新用户方法
     * @
     * @return
     */
    public DayStaticEntity save(DayStaticEntity dayStaticEntity){
        return dayStaticJPA.save(dayStaticEntity);
    }
}
