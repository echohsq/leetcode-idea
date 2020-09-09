//给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。 
//
// 
//
// 示例： 
//二叉树：[3,9,20,null,null,15,7], 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回其层次遍历结果： 
//
// [
//  [3],
//  [9,20],
//  [15,7]
//]
// 
// Related Topics 树 广度优先搜索 
// 👍 624 👎 0


package com.javatiku.leetcode.editor.cn;


import java.util.*;

/**
 * @author hsqzs
 */
public class BinaryTreeLevelOrderTraversal{
  public static void main(String[] args) {
      TreeNode root = new TreeNode(3);
      TreeNode r1 = new TreeNode(9);
      TreeNode r2 = new TreeNode(20);
      TreeNode r3 = new TreeNode(15);
      TreeNode r4 = new TreeNode(7);
      root.left = r1;
      root.right = r2;
      r2.left = r3;
      r2.right = r4;
       Solution solution = new BinaryTreeLevelOrderTraversal().new Solution();
      List<List<Integer>> l = solution.levelOrder(null);
      System.out.println(l);
  }
  //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        TreeNode curr = root;
        int cnt = 1;
        int n = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        queue.offer(curr);
        while (!queue.isEmpty()) {
            if (curr.left != null) {
                queue.offer(curr.left);
            }else {
                n ++;
            }
            if (curr.right != null) {
                queue.offer(curr.right);
            }else {
                n ++;
            }
            list.add(Objects.requireNonNull(queue.poll()).val);
            if (list.size() == cnt) {
                lists.add(list);
                list = new ArrayList<>();
                cnt = cnt*2 - n;
                n = 0;
            }
            curr = queue.peek();
        }
        return lists;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}