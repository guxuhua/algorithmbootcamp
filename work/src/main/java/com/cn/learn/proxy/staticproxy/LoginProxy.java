package com.cn.learn.proxy.staticproxy;

/**
 * 代理类：对登陆做代理，对登陆做耗时统计
 *
 * @author guxh@asiainfo.com
 * @version 1.0
 * @date 2022/1/19 1:41 PM
 */
public class LoginProxy implements ILogin {

    /**
     * 组合实际执行登陆的类
     */
    private ILogin login;

    public LoginProxy(ILogin login) {
        this.login = login;
    }

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
        long begin = System.currentTimeMillis();
        boolean flag = this.login.login(name, password);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println("登陆接口执行时长：" + (end - begin) + "ms");
        return flag;
    }
}
