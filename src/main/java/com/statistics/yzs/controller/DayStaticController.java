package com.statistics.yzs.controller;

import com.statistics.yzs.entity.DayStaticEntity;
import com.statistics.yzs.service.DayStaticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Lgq
 * @Desc
 * @create 2019-01-11 17:22
 **/
@RestController
@RequestMapping(value = "/dayStat")
public class DayStaticController {
    @Autowired
    private DayStaticService dayStaticService;

    /**
     * 查询数据
     * @return
     */
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public List<DayStaticEntity> list(){
        try {
            return dayStaticService.list();
        }catch (Exception e){
            e.printStackTrace();
            return new ArrayList<DayStaticEntity>();
        }
    }

    /**
     *保存数据
     */
    @RequestMapping(value = "/save",method = RequestMethod.GET)
    public DayStaticEntity save(DayStaticEntity dayStaticEntity){
        try{
            return dayStaticService.save(dayStaticEntity);
        }catch (Exception e){
            e.printStackTrace();
            return new DayStaticEntity();
        }
    }
}
