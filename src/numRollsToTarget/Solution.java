package numRollsToTarget;

/**
 * 这里有 n 个一样的骰子，每个骰子上都有 k 个面，分别标号为 1 到 k 。
 *
 * 给定三个整数 n ,  k 和 target ，返回可能的方式(从总共 kn 种方式中)滚动骰子的数量，使正面朝上的数字之和等于 target 。
 *
 * 答案可能很大，你需要对 109 + 7 取模 。
 */
class Solution {
    public int numRollsToTarget(int n, int k, int target) {
        int mod = (int) (1e9 + 7);
        //思路：二维 dp，第一维为使用骰子个数，第二维为骰子点数之和，存储得到对应结果的方案数量
        //遍历的骰子个数为 i，点数之和为 j
        //设第i个骰子的点数为l，则前 i - 1 个骰子得到的点数应当为 j - l
        //由于i个骰子得到j的方式可能不止一种，因此还需加上原本得到的方案数
        //由此得到状态转移方程 dp[i][j] = dp[i - 1][j - l] + dp[i][j]
        //由于结果需要等于 n, target，因此数组下标范围 + 1 防止越界
        //初始化边界条件 dp[0][0] = 1
        int[][] dp = new int[n + 1][target + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= n; i++)
            for (int j = i; j <= target; j++)
                for (int l = 1; l <= k && l <= j; l++)
                    dp[i][j] = (dp[i][j] + dp[i - 1][j - l]) % mod;
        return dp[n][target];
    }
}