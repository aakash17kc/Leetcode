package com.leetcode.tree;

import java.util.*;

public class TreeTraversal {

  public static void main(String[] args) {
    TreeNode node = new TreeNode(4,null,null);
    node.left = new TreeNode(10,null,null);
    node.right = new TreeNode(2,null,null);
    node.left.left = new TreeNode(9,null,null);
    node.left.right = new TreeNode(7,null,null);
//    preorder(node);
//    inorder(node);
//    postorder(node);
//    levelOrder(node);
   System.out.println( new TreeTraversal().decodeString("3[a]2[bc]"));
  }

  private static void preorder(TreeNode node) {
    LinkedList<Integer> out = new LinkedList<>();
    LinkedList<TreeNode> stack = new LinkedList<>();
    if(node == null){
      System.out.println();
    }
    stack.add(node);
    while (!stack.isEmpty()){
      node = stack.pollLast();
      out.add(node.val);
      if(node.right!=null){
        stack.add(node.right);
      }
      if(node.left!=null){
        stack.add(node.left);
      }
    }
    while (!out.isEmpty()){
      System.out.print(out.pollFirst()+" ");
    }

  }

  private static  void inorder(TreeNode node) {
    List<Integer> out = new ArrayList<>();
    LinkedList<TreeNode> stack = new LinkedList<>();
    TreeNode curr = node;
    while (curr != null || !stack.isEmpty()) {
      while (curr != null) {
        stack.add(curr);
        curr = curr.left;
      }
      curr = stack.pollLast();
      out.add(curr.val);
      curr = curr.right;
    }
    out.forEach(x -> System.out.print(x + " "));
  }

  private static  void postorder(TreeNode node) {
    List<Integer> out = new ArrayList<>();
    LinkedList<TreeNode> stack = new LinkedList<>();
    do{
      while (node!=null){
        stack.add(node);
        node = node.left;
      }
      TreeNode prev = null;

      while (node==null && !stack.isEmpty()){
        node = stack.peekLast();
        if(node.right == null || node.right == prev){
          out.add(node.val);
          stack.pollLast();
          prev = node;
          node = null;
        }else {
          node = node.right;
        }
      }

    }while (!stack.isEmpty());
    out.forEach(x -> System.out.print(x + " "));

  }
  public String decodeString(String s) {
    Stack<Character> stack = new Stack<>();
    StringBuilder finalStr = new StringBuilder();
    Stack<Character> stack2 = new Stack<>();
    for(int i=0; i<s.length();i++)
    {

      Character c = s.charAt(i);
      if(c.equals(']')){
        StringBuilder sb = new StringBuilder();
        char  temp = stack.pop();
        while(!Objects.equals(temp, '[')){
          sb.append(temp);
          temp = stack.pop();
        }
        String str = sb.toString();
        int base = 1;
        int k = 0;
        while (!stack.isEmpty() && Character.isDigit(stack.peek())) {
          k = k + (stack.pop() - '0') * base;
          base *= 10;
        }
        while(k!=0){
          for (int j = 0; j < str.length(); j++) {
            stack2.push(str.charAt(j));
          }
          k--;
        }
      }else{
        stack.push(c);
      }
    }
    while(!stack2.isEmpty()){
      finalStr.append(stack2.pop());
    }
    return finalStr.toString();

  }
  private static  void levelOrder(TreeNode node) {

    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(node);
    queue.offer(null);
    List<List<Integer>> lists = new ArrayList<>();
    List<Integer> values = new ArrayList<>();
    while (!queue.isEmpty()){
      TreeNode node1 = queue.poll();
      if(node1 == null){
          if(!queue.isEmpty()){
            queue.offer(null);
          }
          lists.add(values);
          values = new ArrayList<>();
      }
      else{
        values.add(node1.val);
        if(node1.left!=null)
          queue.offer(node1.left);
        if(node1.right!=null)
          queue.offer(node1.right);
      }
    }

      lists.forEach(list -> System.out.println(list));

  }
}
