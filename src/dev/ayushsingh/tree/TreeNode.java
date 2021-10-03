package dev.ayushsingh.tree;

public class TreeNode {

  public int data;
  public TreeNode left, right;

  TreeNode(int data) {
    this(data, null, null);
  }

  TreeNode(int data, TreeNode lNode, TreeNode rNode) {
    this.data = data;
    this.left = lNode;
    this.right = rNode;
  }

  public void addLeftChild(TreeNode x) {
    this.left = x;
  }

  public void addRightChild(TreeNode x) {
    this.right = x;
  }
}
