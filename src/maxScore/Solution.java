package maxScore;

/**
 * 几张卡牌 排成一行，每张卡牌都有一个对应的点数。点数由整数数组 cardPoints 给出。
 *
 * 每次行动，你可以从行的开头或者末尾拿一张卡牌，最终你必须正好拿 k 张卡牌。
 *
 * 你的点数就是你拿到手中的所有卡牌的点数之和。
 *
 * 给你一个整数数组 cardPoints 和整数 k，请你返回可以获得的最大点数。
 */
class Solution {
    /**
     * public static int maxScore(int[] cardPoints, int k) {
     *     int sum = 0;
     *     for(int i = 0 ; i <k;i++){
     *         sum += cardPoints[i];
     *     }
     *     int max = sum;
     *     int n = cardPoints.length -1;
     *
     *     for(int i= 0; i<k;i++){
     *         sum = sum + cardPoints[n-i] - cardPoints[k-i-1];
     *         max = Math.max(max,sum);
     *     }
     *
     *     return max;
     *     }
     *
     */
    public static int maxScore(int[] cardPoints, int k) {
        int sum = 0;
        int i = 0;
        int left = 0;
        int right = cardPoints.length-1;
        while(k>i){
            if(cardPoints[left]>cardPoints[right]){
                sum=sum+cardPoints[left];
                left++;
                i++;
            }
            else if(cardPoints[left]<cardPoints[right]){
                sum = sum+cardPoints[right];
                right--;
                i++;
            }
            else{
                if(cardPoints[left+1]>cardPoints[right-1]){
                    sum=sum+cardPoints[left];
                    left++;
                    i++;
                }
                else{
                    sum = sum+cardPoints[right];
                    right--;
                    i++;
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] c = {1,2,3,4,5,6,1};
        System.out.println(maxScore(c,3));
    }

}
