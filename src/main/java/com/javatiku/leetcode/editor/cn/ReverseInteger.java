//给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。 
//
// 示例 1: 
//
// 输入: 123
//输出: 321
// 
//
// 示例 2: 
//
// 输入: -123
//输出: -321
// 
//
// 示例 3: 
//
// 输入: 120
//输出: 21
// 
//
// 注意: 
//
// 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231, 231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。 
// Related Topics 数学 
// 👍 2161 👎 0


package com.javatiku.leetcode.editor.cn;

import java.util.Arrays;

public class ReverseInteger{
  public static void main(String[] args) {
       int solution = new ReverseInteger().new Solution().reverse(-1238878999);
      System.out.println(solution);
  }
  //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 反转整数
     */
    class Solution {
    public int reverse(int x) {
        int MAX = Integer.MAX_VALUE;
        int MIN = Integer.MIN_VALUE;
        long tmp = 0L;
        while (x != 0) {
            tmp = tmp*10 + x%10;
            x = x/10;
        }
        if (tmp < MIN || tmp > MAX) {
            return 0;
        }
        return (int) tmp;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}