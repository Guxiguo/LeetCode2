package tupleSameProduct;

import java.util.HashMap;
import java.util.Map;


/**
 * 给你一个由 不同 正整数组成的数组 nums ，请你返回满足 a * b = c * d 的元组 (a, b, c, d) 的数量。其中 a、b、c 和 d 都是 nums 中的元素，且 a != b != c != d 。
 */
class Solution {
    public int tupleSameProduct(int[] nums) {
        int count=0;
        int n=nums.length;
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int fact=nums[i]*nums[j];
                map.put(fact,map.getOrDefault(fact,0)+1);
            }
        }
        for(int m:map.keySet()){
            int times=map.get(m);
            if(times==2){
                count+=8;
            }else if(times>2){
                count+=8*(times*(times-1)/2);
            }
        }
        return count;
    }
}