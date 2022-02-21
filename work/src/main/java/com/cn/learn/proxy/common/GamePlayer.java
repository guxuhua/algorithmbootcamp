package com.cn.learn.proxy.common;

/**
 * 游戏玩家
 *
 * @author guxuhua
 * @version 1.0
 * @date 2021/12/30 3:54 PM
 */
public class GamePlayer implements IGamePlayer {

    /**
     * 玩家的用户名
     */
    private String userName;

    public GamePlayer(String userName) {
        this.userName = userName;
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
    @Override
    public boolean login(String name, String passwd) {
        System.out.println(String.format(">>>>>为用户：%s,密码为：%s执行登陆<<<<<", name, passwd));
        if (name.equals(this.userName) && null != passwd) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    /**
     * 击杀游戏BOSS
     *
     * @author guxuhua
     * @date 2021/12/30 3:53 PM
     **/
    @Override
    public void killBoss() {
        System.out.println(String.format(">>>>>玩家：%s在击杀BOSS<<<<<", this.userName));
    }

    /**
     * 升级
     *
     * @author guxuhua
     * @date 2021/12/30 3:54 PM
     **/
    @Override
    public void upgrade() {
        System.out.println(String.format(">>>>>玩家：%s升级<<<<<", this.userName));
    }
}
