package com.cn.dailywork.weekfour.day22;

/**
 * 力扣 684题：冗余连接
 *
 * @author guxh@asiainfo.com
 * @version 1.0
 * @date 2022/3/14 10:44 PM
 */
public class RedundantConnection {

    /**
     * 树可以看成是一个连通且 无环 的 无向 图。
     * 给定往一棵 n 个节点 (节点值 1～n) 的树中添加一条边后的图。添加的边的两个顶点包含在 1 到 n 中间，且这条附加的边不属于树中已存在的边。图的信息记录于长度为 n 的二维数组 edges ，edges[i] = [ai, bi] 表示图中在 ai 和 bi 之间存在一条边。
     * 请找出一条可以删去的边，删除后可使得剩余部分是一个有着 n 个节点的树。如果有多个答案，则返回数组 edges 中最后出现的边。
     *
     * @param edges 输入项
     * @return int[]
     * @author guxuhua
     * @date 2022/3/14 10:45 PM
     **/
    public int[] findRedundantConnection(int[][] edges) {
        int[] parent = new int[edges.length + 1];
        for (int i = 1; i <= edges.length; i++) {
            parent[i] = i;
        }
        for (int[] ans : edges) {
            int node1 = ans[0], node2 = ans[1];
            if (find(parent, node1) != find(parent, node2)) {
                union(parent, node1, node2);
            } else {
                return ans;
            }
        }
        return new int[0];
    }

    public void union(int[] parent, int index1, int index2) {
        parent[find(parent, index1)] = find(parent, index2);
    }

    public int find(int[] parent, int index) {
        if (parent[index] != index) {
            parent[index] = find(parent, parent[index]);
        }
        return parent[index];
    }
}
