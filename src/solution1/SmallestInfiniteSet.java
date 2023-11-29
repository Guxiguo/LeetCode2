package solution1;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * 现有一个包含所有正整数的集合 [1, 2, 3, 4, 5, ...] 。
 *
 * 实现 SmallestInfiniteSet 类：
 *
 * SmallestInfiniteSet() 初始化 SmallestInfiniteSet 对象以包含 所有 正整数。
 * int popSmallest() 移除 并返回该无限集中的最小整数。
 * void addBack(int num) 如果正整数 num 不 存在于无限集中，则将一个 num 添加 到该无限集最后。
 */
class SmallestInfiniteSet {
    private int thres;
    private TreeSet<Integer> set;

    public SmallestInfiniteSet() {
        thres = 1;
        set = new TreeSet<Integer>();
    }

    public int popSmallest() {
        if (set.isEmpty()) {
            int ans = thres;
            ++thres;
            return ans;
        }
        int ans = set.pollFirst();
        return ans;
    }

    public void addBack(int num) {
        if (num < thres) {
            set.add(num);
        }
    }
}
