package com.leetcode.tree;

public class LowestCommonAncestor {
  TreeNode ans;

  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

    recursive(root, p, q);
    return ans;

  }

  private boolean recursive(TreeNode root, TreeNode p, TreeNode q) {

    int left = recursive(root.left, p, q) ? 1 : 0;
    int right = recursive(root.right, p, q) ? 1 : 0;
    int mid = (root == p) || root == q ? 1 : 0;

    if (left + mid + right >= 2) {
      this.ans = root;
    }
    return (left + right + mid > 0);

  }

  public static void main(String[] args) {

  }
}
