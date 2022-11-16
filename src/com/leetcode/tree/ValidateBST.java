package com.leetcode.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ValidateBST {

  public boolean recursive(TreeNode root){
    boolean isBST =  validate(root,null,null);
    isBST = inorder(root);
    return isBST;

  }

  private boolean inorder(TreeNode root) {
    Stack<TreeNode> stack = new Stack<>();
    Integer prev = null;
    while (root!=null || !stack.isEmpty()){
      while (root!=null){
        stack.push(root);
        root = root.left;
      }
      root = stack.pop();
      if(prev!=null && root.val<=prev){
        return false;
      }
      prev = root.val;
      root = root.right;
    }
    return true;
  }

  private List<Integer> normalInoder(TreeNode root){

    Stack<TreeNode> stack = new Stack<>();
    List<Integer> list = new ArrayList<>();
    Integer prev = null;
    while (root!=null || !stack.isEmpty()){
      while (root!=null){
        stack.push(root);
        root = root.left;
      }
      root = stack.pop();

      list.add(root.val);
      root = root.right;
    }
    return list;
  }

  private boolean validate(TreeNode root, Integer left, Integer right) {
    if(root==null)
      return true;
    if(left > root.val || right < root.val)
      return false;
    return validate(root.left,left,root.val) && validate(root.right,root.val,right);
  }



  public static void main(String[] args) {

  }
}
