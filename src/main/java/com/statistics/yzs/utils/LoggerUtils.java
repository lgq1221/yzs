package com.statistics.yzs.utils;

import com.statistics.yzs.constants.Constant;
import eu.bitwalker.useragentutils.Browser;
import eu.bitwalker.useragentutils.OperatingSystem;
import eu.bitwalker.useragentutils.UserAgent;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Lgq
 * @Desc
 * @create 2019-04-25 17:11
 **/
public class LoggerUtils {
    /**
     * 获取客户端ip
     * @param request
     * @return
     */
    public static String getClientIp(HttpServletRequest request){
        return request.getRemoteAddr();
    }

    /**
     * 获取客户端 类型
     * @param request
     * @return
     */
    public static String getRequestType(HttpServletRequest request){
        String User_Agent = request.getHeader("User-Agent");
        if (User_Agent.contains(Constant.ANDROID_CLIENT)||User_Agent.contains(Constant.LINUX_CLIENT)) {
            System.out.println("Android移动客户端");
            if (User_Agent.contains(Constant.MICROMESSENGER_CLIENT)) {
                System.out.println("安卓微信");
            }
        } else if (User_Agent.contains(Constant.IOS_CLIENT)) {
            System.out .println("iPhone移动客户端");
            if (User_Agent.contains(Constant.MICROMESSENGER_CLIENT)) {
                System.out.println("IPhone微信");
            }
        } else if (User_Agent.contains(Constant.IPAD_CLIENT)) {
            System.out.println("iPad客户端");
            if (User_Agent.contains(Constant.MICROMESSENGER_CLIENT)) {
                System.out.println("iPad微信");
            }
        } else if(User_Agent.contains(Constant.WINDOWS_CLIENT)){
            System.out.println("Windows");
        }
        return User_Agent;
    }

    /**
     * 获取客户端 类型
     * @param request
     * @return
     */
    public static String getRequestTypeUserAgent(HttpServletRequest request){
        UserAgent userAgent = UserAgent.parseUserAgentString(request.getHeader("User-Agent"));
        Browser browser = userAgent.getBrowser();
        OperatingSystem os = userAgent.getOperatingSystem();
        return os.getDeviceType().getName();
    }
}
