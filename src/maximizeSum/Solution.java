package maximizeSum;
/**
 * 给你一个下标从 0 开始的整数数组 nums 和一个整数 k 。你需要执行以下操作 恰好 k 次，最大化你的得分：
 *
 * 从 nums 中选择一个元素 m 。
 * 将选中的元素 m 从数组中删除。
 * 将新元素 m + 1 添加到数组中。
 * 你的得分增加 m 。
 * 请你返回执行以上操作恰好 k 次后的最大得分。
 */

import java.util.Arrays;

class Solution {
    public static int maximizeSum(int[] nums, int k) {
        Arrays.sort(nums);
        int sum = 0;
        int length = nums.length;
        for(int i=0;i<k;i++){
            sum = sum +nums[length-1];
            nums[length-1] = nums[length-1]+1;
        }
        return sum;

    }

    public static void main(String[] args) {
        int[] array = {1,2,3,4,5};
        System.out.println(maximizeSum(array,3));
    }
}