package com.cn.learn.proxy.staticproxy;

/**
 * 登陆接口
 *
 * @author guxuhua
 * @version 1.0
 * @date 2022/1/19 1:34 PM
 */
public interface ILogin {

    /**
     * 登陆方法
     *
     * @param name     登陆名
     * @param password 密码
     * @return boolean
     * @author guxuhua
     * @date 2022/1/19 1:35 PM
     **/
    boolean login(String name, String password);
}
