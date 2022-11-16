package com.leetcode.tree;

import java.util.Stack;

public class InorderSuccessor {
  public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {

    Stack<TreeNode> stack = new Stack<>();
    boolean found = false;
    while (root!=null || !stack.isEmpty()){
      while (root!=null){
        stack.push(root);
        root = root.left;
      }
      root = stack.pop();
      if(found)
        return root;

      if(root==p)
        found=true;
      root = root.right;
    }
    return null;

  }
  public static void main(String[] args) {

  }
}
