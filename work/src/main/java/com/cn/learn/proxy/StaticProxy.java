package com.cn.learn.proxy;

import com.cn.learn.proxy.common.GamePlayer;
import com.cn.learn.proxy.common.IGamePlayer;

/**
 * 静态代理
 *
 * @author guxuhua
 * @version 1.0
 * @date 2021/12/30 4:17 PM
 */
public class StaticProxy implements IGamePlayer {
    /**
     * 被代理的对象
     */
    private IGamePlayer gamePlayer;

    public StaticProxy(IGamePlayer player) {
        System.out.println("=====静态代理执行=====");
        this.gamePlayer = player;
    }

    /**
     * 执行登陆
     *
     * @param name   登陆用户名
     * @param passwd 登陆密码
     * @return boolean
     * @author guxuhua
     * @date 2021/12/30 3:52 PM
     **/
    public boolean login(String name, String passwd) {
        return this.gamePlayer.login(name, passwd);
    }

    /**
     * 击杀游戏BOSS
     *
     * @author guxuhua
     * @date 2021/12/30 3:53 PM
     **/
    public void killBoss() {
        this.gamePlayer.killBoss();
    }

    /**
     * 升级
     *
     * @author guxuhua
     * @date 2021/12/30 3:54 PM
     **/
    public void upgrade() {
        this.gamePlayer.upgrade();
    }
}
