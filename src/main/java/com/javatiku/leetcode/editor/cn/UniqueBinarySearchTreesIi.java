//给定一个整数 n，生成所有由 1 ... n 为节点所组成的 二叉搜索树 。 
//
// 
//
// 示例： 
//
// 输入：3
//输出：
//[
//  [1,null,3,2],
//  [3,2,null,1],
//  [3,1,null,null,2],
//  [2,1,3],
//  [1,null,2,null,3]
//]
//解释：
//以上的输出对应以下 5 种不同结构的二叉搜索树：
//
//   1         3     3      2      1
//    \       /     /      / \      \
//     3     2     1      1   3      2
//    /     /       \                 \
//   2     1         2                 3
// 
//
// 
//
// 提示： 
//
// 
// 0 <= n <= 8 
// 
// Related Topics 树 动态规划 
// 👍 623 👎 0


package com.javatiku.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class UniqueBinarySearchTreesIi{
  public static void main(String[] args) {
       Solution solution = new UniqueBinarySearchTreesIi().new Solution();
  }
  //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
 //public static class TreeNode {
 //     int val;
 //     TreeNode left;
 //     TreeNode right;
 //     TreeNode() {}
 //     TreeNode(int val) { this.val = val; }
 //     TreeNode(int val, TreeNode left, TreeNode right) {
 //         this.val = val;
 //         this.left = left;
 //         this.right = right;
 //     }
 //}

class Solution {
    //输出 1~n 元素组成的 BST 所有解。这一题递归求解即可。外层循环遍历 1~n 所有结点，作为根结点，内层双层递归分别求出左子树和右子树。
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new ArrayList<TreeNode>();
        }
        return generateBiTree(1, n);
    }

    public List<TreeNode> generateBiTree(int start, int end) {
        List<TreeNode> list = new ArrayList<>();
        if (start > end) {
            list.add(null);
            return list;
        }
        for (int i = start; i <= end; i++) {
            List<TreeNode> leftNodes = generateBiTree(start, i-1);
            List<TreeNode> rightNodes = generateBiTree(i+1, end);
            for (TreeNode lt : leftNodes) {
                for(TreeNode rt : rightNodes) {
                    TreeNode root = new TreeNode(i);
                    root.left = lt;
                    root.right = rt;
                    list.add(root);
                }
            }
        }
        return list;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}