//给定一个二叉树，返回它的中序 遍历。 
//
// 示例: 
//
// 输入: [1,null,2,3]
//   1
//    \
//     2
//    /
//   3
//
//输出: [1,3,2] 
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树 哈希表 
// 👍 663 👎 0


package com.javatiku.leetcode.editor.cn;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author hsqzs
 */
public class BinaryTreeInorderTraversal{

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
       Solution solution = new BinaryTreeInorderTraversal().new Solution();
      System.out.println(solution.inorderTraversal(root));
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
      TreeNode(int x) { val = x; }
  }
class Solution {
      // 一定要在子节点上添加下面的null节点，有助于思考问题。
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        TreeNode curr = root;
        while(!stack.isEmpty() || curr != null) {
            while (curr != null) {
                // 只要有左子节点就插入到stack中
                stack.add(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            list.add(curr.val);
            // 弹出的节点都为中间节点，转换为右子节点
            curr = curr.right;
        }
        return list;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}