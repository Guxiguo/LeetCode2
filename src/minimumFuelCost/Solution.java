package minimumFuelCost;
/**
 * 给你一棵 n 个节点的树（一个无向、连通、无环图），每个节点表示一个城市，编号从 0 到 n - 1 ，且恰好有 n - 1 条路。0 是首都。给你一个二维整数数组 roads ，其中 roads[i] = [ai, bi] ，表示城市 ai 和 bi 之间有一条 双向路 。
 *
 * 每个城市里有一个代表，他们都要去首都参加一个会议。
 *
 * 每座城市里有一辆车。给你一个整数 seats 表示每辆车里面座位的数目。
 *
 * 城市里的代表可以选择乘坐所在城市的车，或者乘坐其他城市的车。相邻城市之间一辆车的油耗是一升汽油。
 *
 * 请你返回到达首都最少需要多少升汽油。
 */

import java.util.ArrayList;
import java.util.List;

class Solution {
    long res = 0;
    public long minimumFuelCost(int[][] roads, int seats) {
        List<Integer>[] array = new List[roads.length+1];
        for(int i =0;i<array.length;i++) {
            array[i] = new ArrayList<>();
        }
        for(int[] e:roads){
            array[e[0]].add(e[1]);
            array[e[1]].add(e[0]);
        }
        dfs(0,-1,seats,array);
    return res;
    }
    public int dfs(int cur, int fa, int seats, List<Integer>[] g){
        int peopleSum = 1;
        for (int ne : g[cur]) {
            if (ne != fa) {
                int peopleCnt = dfs(ne, cur, seats, g);
                peopleSum += peopleCnt;
                res += (peopleCnt + seats - 1) / seats;
            }
        }
        return peopleSum;
    }
}
