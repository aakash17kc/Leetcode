package com.leetcode.datastructures;

import com.example.tree.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class BuildTree {
  int[] inorder, postorder;
  Map<Integer, Integer> inorderMap = new HashMap<>();
  int post_ind;


  public TreeNode buildFromInorderPostOrder(int[] inorder, int[] postorder) {
    this.inorder = inorder;
    this.postorder = postorder;

    post_ind = postorder.length - 1;
    for (int i = 0; i < inorder.length; i++) {
      inorderMap.put(inorder[i], i);
    }

    return helper(0, inorder.length - 1);


  }

  private TreeNode helper(int ind_left, int ind_right) {
    if (ind_left > ind_right) {
      return null;
    }
    int item = postorder[post_ind];
    TreeNode treeNode = new TreeNode(item);
    int ind = inorderMap.get(item);
    treeNode.left = helper(ind_left, ind - 1);
    treeNode.right = helper(ind + 1, ind_right);
    return treeNode;
  }

  public static void main(String[] args) {


  }
}
