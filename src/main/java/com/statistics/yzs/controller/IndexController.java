package com.statistics.yzs.controller;

import com.alibaba.fastjson.JSONObject;
import com.statistics.yzs.constants.Constant;
import com.statistics.yzs.entity.SysUserEntity;
import com.statistics.yzs.jpa.SysUserJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
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
@Controller
@RequestMapping(value = "/user")
public class IndexController {
    @RequestMapping(value = "/login_view",method = RequestMethod.GET)
    public String login_view(){
        return "login";
    }
    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public String index() {
        return "first";
    }

    /**
     * 测试请求日志拦截器
     * @param request
     * @param name
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public JSONObject login(HttpServletRequest request,String name)throws Exception{
        JSONObject obj = new JSONObject();
        obj.put("msg","用户："+name+",登陆成功。");
        //将返回值写入到请求对象中
        request.setAttribute(Constant.LOGGER_RETURN,obj);
        return obj;
    }
}
