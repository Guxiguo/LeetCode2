package matrixSum;

import java.util.Arrays;
import java.util.Collections;

/**
 * 给你一个下标从 0 开始的二维整数数组 nums 。一开始你的分数为 0 。你需要执行以下操作直到矩阵变为空：
 *
 * 矩阵中每一行选取最大的一个数，并删除它。如果一行中有多个最大的数，选择任意一个并删除。
 * 在步骤 1 删除的所有数字中找到最大的一个数字，将它添加到你的 分数 中。
 */
class Solution {
    public int matrixSum(int[][] nums) {
        int sum = 0;
        for(int i = 0;i<nums.length;i++){
            Arrays.sort(nums[i]);}
        for(int j=0;j<nums[0].length;j++){
            int maxAll = Integer.MIN_VALUE;
            for(int i=0;i<nums.length;i++){
                maxAll =  Math.max(maxAll, nums[i][j]);
            }
            sum = sum+maxAll;
        }
        return sum;

    }
}