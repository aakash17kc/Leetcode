package com.leetcode.tree;

public class RightNextPointer {
  //1. level order traversal, O(n) space.

  public TreeNode connect(TreeNode root) {
    if (root == null) {
      return null;
    }
    TreeNode leftMost = root;
    while (leftMost.left != null) {
      TreeNode head = leftMost;
      // for 1 level
      while (head != null) {
        head.left.next = head.right;

        if (head.next != null) {
          head.right.next = head.next.left;
        }
        head = head.next; //right side
      }
      //level complete
      leftMost = leftMost.left; //left side next level
    }
    return root;

  }

  public static void main(String[] args) {

  }
}
