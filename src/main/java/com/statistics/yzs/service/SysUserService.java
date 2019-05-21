package com.statistics.yzs.service;

import com.statistics.yzs.entity.DayStaticEntity;
import com.statistics.yzs.entity.SysUserEntity;
import com.statistics.yzs.jpa.SysUserJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Lgq
 * @Desc
 * @create 2019-01-15 14:50
 **/
@Service
public class SysUserService {
    @Autowired
    private SysUserJPA sysUserJPA;
    /**
     * 查询数据统计列表
     * @return
     */
    public List<SysUserEntity> list(){
        return sysUserJPA.findAll();
    }

    /**
     * 添加、更新用户方法
     * @
     * @return
     */
    public SysUserEntity save(SysUserEntity dayStaticEntity){
        return sysUserJPA.save(dayStaticEntity);
    }
}
