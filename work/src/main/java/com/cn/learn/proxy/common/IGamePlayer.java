package com.cn.learn.proxy.common;

/**
 * 游戏操作的接口类
 *
 * @author guxuhua
 * @version 1.0
 * @date 2021/12/30 3:51 PM
 */
public interface IGamePlayer {

    /**
     * 执行登陆
     *
     * @param name   登陆用户名
     * @param passwd 登陆密码
     * @return boolean
     * @author guxuhua
     * @date 2021/12/30 3:52 PM
     **/
    boolean login(String name, String passwd);

    /**
     * 击杀游戏BOSS
     *
     * @author guxuhua
     * @date 2021/12/30 3:53 PM
     **/
    void killBoss();

    /**
     * 升级
     *
     * @author guxuhua
     * @date 2021/12/30 3:54 PM
     **/
    void upgrade();
}
