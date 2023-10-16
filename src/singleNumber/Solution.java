package singleNumber;

import java.util.Arrays;


/**
 * 给你一个整数数组 nums ，除某个元素仅出现 一次 外，其余每个元素都恰出现 三次 。请你找出并返回那个只出现了一次的元素。
 *
 * 你必须设计并实现线性时间复杂度的算法且使用常数级空间来解决此问题。
 */
class Solution {
    public static int singleNumber(int[] nums) {
        if(nums.length == 1) return nums[0];
        Arrays.sort(nums);


        for(int i=0;i<nums.length-2;i=i+3) {
            if(nums[i] == nums[i + 2]) {
                continue;
            }
            int ans = 0;
            ans ^= nums[i] ;
            ans ^= nums[i + 1];
            ans ^= nums[i + 2];
            return ans;
        }
        return nums[nums.length - 1];

    }

    public static void main(String[] args) {
        int[] array = {0,1,0,1,0,1,99};
        System.out.println(singleNumber(array));
    }
}
