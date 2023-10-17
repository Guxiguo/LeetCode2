package singleNumberTwo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * 给你一个整数数组 nums，其中恰好有两个元素只出现一次，其余所有元素均出现两次。 找出只出现一次的那两个元素。你可以按 任意顺序 返回答案。
 *
 * 你必须设计并实现线性时间复杂度的算法且仅使用常量额外空间来解决此问题。
 */

class Solution {
    public static int[] singleNumber(int[] nums) {
        int count = 0;
        int[] answer = new int[2];
        Arrays.sort(nums);
        for(int i=0;i<nums.length - 1;i+=2){
            if(nums[i]!=nums[i+1]){
                answer[count++] = nums[i];
                i--;
                if(count == 2)
                    break;
            }
        }
        if(count == 1)         //只找到了一个数,且数组只剩最后一个了,必定是要找的数
            answer[count++] = nums[nums.length-1];
        return answer;
    }
    public static void main(String[] args) {
        int[] nums = {1, 2, 1, 3, 2, 5};

        System.out.println(singleNumber(nums));
    }
}
