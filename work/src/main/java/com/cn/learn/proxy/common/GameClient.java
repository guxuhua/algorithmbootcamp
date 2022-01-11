package com.cn.learn.proxy.common;

/**
 * @author guxuhua
 * @version 1.0
 * @date 2021/12/30 3:58 PM
 */
public class GameClient {

    public static void main(String[] args) {
        String name = "guxh";
        IGamePlayer player = new GamePlayer(name);

        if (player.login(name, "123456")) {
            player.killBoss();
            player.upgrade();
        } else {
            System.out.println("------登陆失败-----");
        }
    }
}
