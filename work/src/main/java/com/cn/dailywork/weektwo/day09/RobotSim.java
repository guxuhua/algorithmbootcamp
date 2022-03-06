package com.cn.dailywork.weektwo.day09;

import java.util.HashSet;
import java.util.Set;

/**
 * leetcode 874 模拟行走机器人
 *
 * @author guxuhua
 * @version 1.0
 * @date 2022/3/1 2:10 PM
 */
public class RobotSim {
    /**
     * 机器人在一个无限大小的 XY 网格平面上行走，从点 (0, 0) 处开始出发，面向北方。该机器人可以接收以下三种类型的命令 commands ：
     * <p>
     * -2 ：向左转 90 度
     * -1 ：向右转 90 度
     * 1 <= x <= 9 ：向前移动 x 个单位长度
     * 在网格上有一些格子被视为障碍物 obstacles 。第 i 个障碍物位于网格点  obstacles[i] = (xi, yi) 。
     * <p>
     * 机器人无法走到障碍物上，它将会停留在障碍物的前一个网格方块上，但仍然可以继续尝试进行该路线的其余部分。
     * <p>
     * 返回从原点到机器人所有经过的路径点（坐标为整数）的最大欧式距离的平方。（即，如果距离为 5 ，则返回 25 ）
     * <p>
     *  
     * 注意：
     * <p>
     * 北表示 +Y 方向。
     * 东表示 +X 方向。
     * 南表示 -Y 方向。
     * 西表示 -X 方向。
     *
     * @param commands  行进的路径
     * @param obstacles 障碍物的坐标
     * @return int
     * @author guxuhua
     * @date 2022/3/1 2:48 PM
     **/
    public int robotSim(int[] commands, int[][] obstacles) {
        // 极值:行走的数组为空
        if (null == commands) {
            return 0;
        }
        // 将障碍物的二维数组改成散列 --- 查询效率：O(1)
        Set<String> obs = new HashSet<>();
        for (int[] obstacle : obstacles) {
            obs.add(obstacle[0] + "," + obstacle[1]);
        }
        // 返回结果
        int answer = 0;
        // 上北: N-0,下南 S-2,左西 W-3,右东 E-1
        int x = 0, y = 0, dir = 0;
        // 在二维坐标上的行进路线
        int[] dirX = {0, 1, 0, -1};
        int[] dirY = {1, 0, -1, 0};
        for (int command : commands) {
            if (commands[command] == -2) {
                // 向左转 90 度 -1 + 4 = +3
                dir = (dir + 3) % 4;
            } else if (commands[command] == -1) {
                // 右转90度
                dir = (dir + 1) % 4;
            } else {
                // 普通行走
                for (int j = 0; j < command; j++) {
                    int nx = x + dirX[dir];
                    int ny = y + dirY[dir];
                    if (obs.contains(nx + "," + ny)) {
                        // 是障碍物
                        break;
                    }
                    x = nx;
                    y = ny;
                    answer = Math.max(answer, x * x + y * y);
                }

            }
        }

        return answer;
    }
}
