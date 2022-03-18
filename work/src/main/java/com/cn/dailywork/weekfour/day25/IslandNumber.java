package com.cn.dailywork.weekfour.day25;

/**
 * 力扣200题 岛屿数量
 *
 * @author guxh@asiainfo.com
 * @version 1.0
 * @date 2022/3/17 23:43
 */
public class IslandNumber {

    /**
     * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
     * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
     * 此外，你可以假设该网格的四条边均被水包围。
     *
     * @param grid 二维数组
     * @return int
     * @author guxuhua
     * @date 2022/3/17 23:44
     **/
    public int numIslands(char[][] grid) {
        // 排除极值
        if (grid == null || grid.length == 0) {
            return 0;
        }
        // 行
        int row = grid.length;
        // 列
        int clos = grid[0].length;
        // 结果
        int ans = 0;
        for (int r = 0; r < row; ++r) {
            for (int c = 0; c < clos; ++c) {
                if (grid[r][c] == '1') {
                    ++ans;
                    // 深度优先
                    dfs(grid, r, c);
                }
            }
        }

        return ans;
    }

    private void dfs(char[][] grid, int r, int c) {
        int nr = grid.length;
        int nc = grid[0].length;

        if (r < 0 || c < 0 || r >= nr || c >= nc || grid[r][c] == '0') {
            return;
        }

        grid[r][c] = '0';
        dfs(grid, r - 1, c);
        dfs(grid, r + 1, c);
        dfs(grid, r, c - 1);
        dfs(grid, r, c + 1);
    }
}
