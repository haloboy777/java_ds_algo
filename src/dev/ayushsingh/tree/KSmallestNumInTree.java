package dev.ayushsingh.tree;

import java.util.*;

public class KSmallestNumInTree {

  public static void main(String[] args) {
    BSTNode root = new BSTNode(8);
    root.insert(root, 3);
    root.insert(root, 10);
    root.insert(root, 1);
    root.insert(root, 6);
    root.insert(root, 14);
    root.insert(root, 4);
    root.insert(root, 7);
    root.insert(root, 13);


    System.out.println(kthSmallestEl(root, 7));
  }

  static int kthSmallestEl(BSTNode x, int k) {
    if (x == null) return -1;

    // run inOrderTraversal till k and then return the num
    Stack<BSTNode> s = new Stack<>();
    s.push(x);
    int i = 0;
    while (x != null || !s.isEmpty()) {
      while (x != null) {
        s.push(x);
        x = x.left;
      }
      ++i;
      x = s.pop();
      if (i == k) return x.data;
      x = x.right;
    }
    return -1;
  }
}
