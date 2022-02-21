package com.cn.learn.proxy.staticproxy;

/**
 * 调用登陆的客户端代码
 *
 * @author guxuhua
 * @version 1.0
 * @date 2022/1/19 1:38 PM
 */
public class LoginClient {
    public static void main(String[] args) {
        String name = "user";
        String password = "user";
        ILogin login = new CommonLogin();
        if (login.login(name, password)) {
            System.out.println("登陆成功");
        } else {
            System.out.println("登陆失败");
        }
        System.out.println("======静态代理模式=====");
        // 需求修改：登陆时，统计登陆耗时
        // 直接修改登陆方法，有侵入代码之嫌，显得不够优雅，此时考虑代理模式
        login = new LoginProxy(login);
        login.login(name, password);

    }
}
