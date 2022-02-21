package com.cn.learn.proxy;

import com.cn.learn.proxy.common.GamePlayer;
import com.cn.learn.proxy.common.IGamePlayer;

/**
 * 静态代理的测试类
 *
 * @author guxuhua
 * @version 1.0
 * @date 2021/12/30 4:19 PM
 */
public class StaticProxyClient {

    public static void main(String[] args) {
        String name = "静态代理1111";
        // 被代理对象
        IGamePlayer player = new GamePlayer(name);
        // 代理
        StaticProxy proxy = new StaticProxy(player);
        if (proxy.login(name, "123456")) {
            proxy.killBoss();
            proxy.upgrade();
        } else {
            System.out.println("------登陆失败-----");
        }
    }
}
