package com.statistics.yzs;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.statistics.yzs.constants.Constant;
import com.statistics.yzs.entity.LogEntity;
import com.statistics.yzs.jpa.LogJPA;
import com.statistics.yzs.utils.LoggerUtils;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Lgq
 * @Desc 日志拦截器
 * @create 2019-04-25 14:08
 **/
public class LogInterceptor implements HandlerInterceptor {
   //请求开始时间标志
    private static final String LOG_SEND_TIME= "_send_time";
    //请求日志实体标识
    private static final String LOG_ENTITY = "_log_entity";

    /**
     * 进入SpringMVC 的controller 之前开始记录实体类
     * @param httpServletRequest 请求对象
     * @param httpServletResponse 相应对象
     * @param o
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,Object o) throws Exception {
        //创建日志实体
        LogEntity logger = new LogEntity();
        //获取请求sessionId
        String sessionId = httpServletRequest.getRequestedSessionId();
        //请求路径
        String url = httpServletRequest.getRequestURI();
        //获取请求参数信息
        String paramData = JSON.toJSONString(httpServletRequest.getParameterMap(),
        SerializerFeature.DisableCircularReferenceDetect,
        SerializerFeature.WriteMapNullValue);
        //设置客户端ip
        logger.setClientIp(LoggerUtils.getClientIp(httpServletRequest));
        //设置请求类型（json|普通请求）
        logger.setType(LoggerUtils.getRequestTypeUserAgent(httpServletRequest));
        //设置请求参数内容json字符串
        logger.setParamData(paramData);
        //设置请求地址
        logger.setUri(url);
        //设置sessionId
        logger.setSessionId(sessionId);
        //设置请求开始时间
        httpServletRequest.setAttribute(Constant.LOGGER_SEND_TIME,System.currentTimeMillis());
        //设置请求实体到request内，方便afterCompletion 方法调用
        httpServletRequest.setAttribute(Constant.LOGGER_ENTITY,logger);
        return true;
    }
    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView)throws Exception {

    }
    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse,Object o,Exception e) throws Exception{
        //获取请求错误码
        int status = httpServletResponse.getStatus();
        //当前时间
        long currentTime = System.currentTimeMillis();
        //请求开始时间
        long time = Long.valueOf(httpServletRequest.getAttribute(Constant.LOGGER_SEND_TIME).toString());
        //获取本次请求日志实体
        LogEntity logEntity = (LogEntity)httpServletRequest.getAttribute(Constant.LOGGER_ENTITY);
        //设置请求时间差
        logEntity.setTimeConsuming(Integer.valueOf((currentTime-time)+"").toString());
         //设置返回错误码
        logEntity.setHttpStatusCode(status+"");
        //设置返回时间
        logEntity.setReturnTime(currentTime+"");
        //设置返回值
        logEntity.setReturnData(JSON.toJSONString(httpServletRequest.getAttribute(Constant.LOGGER_RETURN),
                SerializerFeature.DisableCircularReferenceDetect,
                SerializerFeature.WriteMapNullValue));
        //执行日志写入数据库
        LogJPA logDAO = getDAO(LogJPA.class,httpServletRequest);
        logDAO.save(logEntity);
    }
    /**
     * 根据传入的类型获取spring管理的对应dao
     * @param clazz 类型
     * @param request 请求对象
     * @param <T>
     *     @return
     */
    private <T> T getDAO(Class<T> clazz, HttpServletRequest request){
        BeanFactory factory = WebApplicationContextUtils.getRequiredWebApplicationContext(request.getServletContext());
        return factory.getBean(clazz);
    }
}
