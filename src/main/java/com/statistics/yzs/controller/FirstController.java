package com.statistics.yzs.controller;

import com.statistics.yzs.entity.SysUserEntity;
import com.statistics.yzs.jpa.SysUserJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

/**
 * @author Lgq
 * @Desc
 * @create 2019-01-14 16:52
 **/
@RestController
@RequestMapping(value = "/user")
public class FirstController {
    @Autowired
    private SysUserJPA sysUserJPA;
    @RequestMapping(value = "/first",method = RequestMethod.GET)
    public String firstPage(){
        return "first";
    }
    @RequestMapping(value = "/login")
    public String login(SysUserEntity sysUserEntity, HttpServletRequest request){
        String result =  "登陆成功";
        boolean flag = true;
        Optional<SysUserEntity> sysUser = sysUserJPA.findOne(new Specification<SysUserEntity>() {
            @Nullable
            @Override
            public Predicate toPredicate(Root<SysUserEntity> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
              criteriaQuery.where(criteriaBuilder.equal(root.get("name"),sysUserEntity.getName()));
                return null;
            }
        });
        //用户不存在
        if(!sysUser.isPresent()){
            flag = false;
            result = "用户不存在，登录失败";
        }
        //密码错误
        else if(!sysUser.get().getPassword().equals(sysUserEntity.getPassword())){
            flag = false;
            result = "用户密码不符，登录失败";
        }
        if(flag){
            //将用户信息存入缓存
            request.getSession().setAttribute("session_user",sysUser);
        }
        return result;
    }
}
