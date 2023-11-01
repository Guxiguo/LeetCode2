package hIndex;


class Solution {
    public static int hIndex(int[] citations) {
        int n = citations.length;
        int left = 0, right = n - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (citations[mid] >= n - mid) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return n - left;
    }

    public static void main(String[] args) {
        int[] array = {100};
        System.out.println(hIndex(array));
    }
}