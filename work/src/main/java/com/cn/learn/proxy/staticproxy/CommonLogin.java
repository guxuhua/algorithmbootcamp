package com.cn.learn.proxy.staticproxy;

/**
 * 登陆的实现类
 *
 * @author guxuhua
 * @version 1.0
 * @date 2022/1/19 1:36 PM
 */
public class CommonLogin implements ILogin {
    /**
     * 登陆的用户名
     */
    private static final String NAME = "test";
    /**
     * 登陆密码
     */
    private static final String PASSWORD = "123456";

    /**
     * 登陆方法
     *
     * @param name     登陆名
     * @param password 密码
     * @return boolean
     * @author guxuhua
     * @date 2022/1/19 1:35 PM
     **/
    @Override
    public boolean login(String name, String password) {

        return NAME.equals(name) && PASSWORD.equals(password);
    }
}
