package successfulPairs;


import java.util.Arrays;

/**
 * 给你两个正整数数组 spells 和 potions ，长度分别为 n 和 m ，其中 spells[i] 表示第 i 个咒语的能量强度，potions[j] 表示第 j 瓶药水的能量强度。
 *
 * 同时给你一个整数 success 。一个咒语和药水的能量强度 相乘 如果 大于等于 success ，那么它们视为一对 成功 的组合。
 *
 * 请你返回一个长度为 n 的整数数组 pairs，其中 pairs[i] 是能跟第 i 个咒语成功组合的 药水 数目。
 */
class Solution {
    /**
     * 方法1，暴力，但测试用例不通过
     * @param spells
     * @param potions
     * @param success
     * @return
     */
    public static int[] successfulPairs(int[] spells, int[] potions, long success) {
        int[] array = new int[spells.length];
        for(int i = 0;i<spells.length;i++){
            array[i] = 0;
        }
        Arrays.sort(potions);
        for(int i = 0;i<spells.length;i++){
            for(int j=potions.length;j>0;j--){
                long suuess = spells[i]*potions[j];
                if(suuess>=success){
                    array[i] =array[i]+1;
                }
                else{
                    break;
                }
            }
        }
        return array;
    }

    /**
     * 方法2
     * @param spells
     * @param potions
     * @param success
     * @return
     */
    public int[] successfulPairs1(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int n = spells.length, m = potions.length;
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            long t = (success + spells[i] - 1) / spells[i] - 1;
            res[i] = m - binarySearch(potions, 0, m - 1, t);
        }
        return res;
    }

    public int binarySearch(int[] arr, int lo, int hi, long target) {
        int res = hi + 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (arr[mid] > target) {
                res = mid;
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] spells = {5,1,3};
        int[] position = {1,2,3,4,5};
        int[] array = successfulPairs(spells,position,7);
        for(int i = 0;i<array.length;i++){
            System.out.println(array[i]);
        }
    }
}