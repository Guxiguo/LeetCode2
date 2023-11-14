package Solution;

public class NumArray {

    private int[] array;
    public NumArray(int[] num){
        this.array = num;
    }
    public void update(int index, int val) {
        array[index] = val;

    }

    public int sumRange(int left, int right) {
        int sum = 0;
        for(int i = left;i<=right;i++){
            sum = sum +array[i];
        }
        return sum;

    }
}
