package com.statistics.yzs.entity;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * @author Lgq
 * @Desc
 * @create 2019-04-24 17:31
 **/
@Entity
@Data
@Table(name="log_info")
public class LogEntity {
    //主键id 编号
    @Id
    @GeneratedValue
    @Column(name="id")
    private Long id;
    //客户端请求ip
    @Column(name="client_ip")
    private String clientIp;
    //客户端请求路径
    @Column(name="uri")
    private String uri;
    //终端请求方式，普通请求，ajax请求
    @Column(name="type")
    private String type;
    //请求方式method,post,get等
    @Column(name="method")
    private String method;
    //请求参数内容json
    @Column(name="param_data")
    private String paramData;
    //请求接口唯一session标识
    @Column(name="session_id")
    private String sessionId;
    //请求时间
    @Column(name="request_time",insertable = false)
    private Timestamp requestdTime;
    //接口返回时间
    @Column(name="return_time")
    private String returnTime;
    //接口返回数据json
    @Column(name="return_data")
    private String returnData;
    //接口请求时间
    @Column(name="time_consuming")
    private String timeConsuming;
    //接口返回错误码
    @Column(name = "http_status_code")
    private String httpStatusCode;
}
