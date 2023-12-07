package minimizeResult;

/**
 * 给你一个下标从 0 开始的字符串 expression ，格式为 "<num1>+<num2>" ，其中 <num1> 和 <num2> 表示正整数。
 *
 * 请你向 expression 中添加一对括号，使得在添加之后， expression 仍然是一个有效的数学表达式，并且计算后可以得到 最小 可能值。左括号 必须 添加在 '+' 的左侧，而右括号必须添加在 '+' 的右侧。
 *
 * 返回添加一对括号后形成的表达式 expression ，且满足 expression 计算得到 最小 可能值。如果存在多个答案都能产生相同结果，返回任意一个答案。
 *
 * 生成的输入满足：expression 的原始值和添加满足要求的任一对括号之后 expression 的值，都符合 32-bit 带符号整数范围。
 */
public class Solution {
    public String minimizeResult(String expression) {
        // 直接枚举
        int addIndex = expression.indexOf('+');
        int len = expression.length();
        int min = Integer.MAX_VALUE;
        int[] pair = new int[2];
        // 以addIndex为分界线两边进行分割
        for (int i = 0; i < addIndex; i++) {
            for (int j = addIndex + 2; j <= len; j++) {
                String s1 = expression.substring(0, i);
                int num1 = "".equals(s1) ? 1 : Integer.parseInt(s1);
                String s2 = expression.substring(i, addIndex);
                int num2 = Integer.parseInt(s2);
                String s3 = expression.substring(addIndex + 1, j);
                int num3 = Integer.parseInt(s3);
                String s4 = expression.substring(j, len);
                int num4 = "".equals(s4) ? 1 : Integer.parseInt(s4);
                int num = num1 * (num2 + num3) * num4;
                if (num < min) {
                    pair = new int[]{i, j};
                    min = num;
                }
            }
        }
        StringBuilder sb = new StringBuilder(expression);
        sb.insert(pair[0], '(');
        sb.insert(pair[1] + 1, ')');
        return sb.toString();
    }
}
