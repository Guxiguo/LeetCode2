package findTheCity;

class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] g = new int[n][n];
        // 初始化邻接矩阵
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                g[i][j] = i == j ? 0 : 0x3f3f3f3f;
            }
        }
        // 存图
        for (int[] e : edges) {
            int a = e[0], b = e[1], c = e[2];
            g[a][b] = g[b][a] = Math.min(g[a][b], c);
        }
        // 最短路
        floyd(g);
        // 统计答案
        int ans = -1, cnt = n + 10;
        for (int i = 0; i < n; i++) {
            int cur = 0;
            for (int j = 0; j < n; j++) {
                if (i != j && g[i][j] <= distanceThreshold) cur++;
            }
            if (cur <= cnt) {
                cnt = cur; ans = i;
            }
        }
        return ans;
    }
    void floyd(int[][] g) {
        int n = g.length;
        // floyd 基本流程为三层循环: [枚举中转点 - 枚举起点 - 枚举终点] => 松弛操作
        for (int p = 0; p < n; p++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    g[i][j] = Math.min(g[i][j], g[i][p] + g[p][j]);
                }
            }
        }
    }
}
