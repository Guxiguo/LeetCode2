package minPathCost;

import java.util.Map;

/**
 * 给你一个下标从 0 开始的整数矩阵 grid ，矩阵大小为 m x n ，由从 0 到 m * n - 1 的不同整数组成。你可以在此矩阵中，从一个单元格移动到 下一行 的任何其他单元格。如果你位于单元格 (x, y) ，且满足 x < m - 1 ，你可以移动到 (x + 1, 0), (x + 1, 1), ..., (x + 1, n - 1) 中的任何一个单元格。注意： 在最后一行中的单元格不能触发移动。
 *
 * 每次可能的移动都需要付出对应的代价，代价用一个下标从 0 开始的二维数组 moveCost 表示，该数组大小为 (m * n) x n ，其中 moveCost[i][j] 是从值为 i 的单元格移动到下一行第 j 列单元格的代价。从 grid 最后一行的单元格移动的代价可以忽略。
 *
 * grid 一条路径的代价是：所有路径经过的单元格的 值之和 加上 所有移动的 代价之和 。从 第一行 任意单元格出发，返回到达 最后一行 任意单元格的最小路径代价。
 */
class Solution {
    public static int minPathCost(int[][] grid, int[][] moveCost) {
        int i = 0;
        int j = 0;
        int sum = 0;
        while (i < grid.length-1 && j < grid[0].length) {
            int[] array = max(grid,moveCost,i,j);
            sum =sum +array[0];
            i++;
            j = array[1];
        }
        sum = sum+grid[grid.length-1][j];
        return sum;
    }
    public static int[] max(int[][] grid,int[][] moveCost,int i,int j){
        int min = Integer.MAX_VALUE;
        int b = 0;
        int[] array = new int[2];
        for(int k=0;k<grid[0].length;k++){
            int sum = grid[i][j] + grid[i+1][k] + moveCost[grid[i][j]][k];
            System.out.println(grid[i][j] +","+ grid[i+1][k] +"," +moveCost[grid[i][j]][k]);
            if(sum<min){
                min = sum;
                b = k;

            }
        }
        array[0] = min - grid[i+1][b];
        array[1] = b;
        System.out.println(array[0]);
        return array;
    }

    /**
     * public int minPathCost(int[][] grid, int[][] moveCost) {
     *         int m = grid.length, n = grid[0].length;
     *         int[][] dp = new int[2][n];
     *         dp[0] = grid[0].clone();
     *         int cur = 0;
     *         for (int i = 1; i < m; i++) {
     *             int next = 1 - cur;
     *             for (int j = 0; j < n; j++) {
     *                 dp[next][j] = Integer.MAX_VALUE;
     *                 for (int k = 0; k < n; k++) {
     *                     dp[next][j] = Math.min(dp[next][j], dp[cur][k] + moveCost[grid[i - 1][k]][j] + grid[i][j]);
     *                 }
     *             }
     *             cur = next;
     *         }
     *         return Arrays.stream(dp[cur]).min().getAsInt();
     *     }
     * 
     */

    public static void main(String[] args) {
        int[][] grid = {{5,3},{4,0},{2,1}};
        int[][] moveCost = {{9,8},{1,5},{10,12},{18,6},{2,4},{14,3}};
        System.out.println(minPathCost(grid,moveCost));
    }
}
