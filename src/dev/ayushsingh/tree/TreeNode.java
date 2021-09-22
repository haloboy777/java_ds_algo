package dev.ayushsingh.tree;

public class TreeNode {

  public int data;
  public TreeNode left, right;

  public TreeNode(int data) {
    this.data = data;
    left = null;
    right = null;
  }

  public TreeNode insert(TreeNode node, int data) {
    if (node == null) {
      return new TreeNode(data);
    } else if (data < node.data) {
      node.left = insert(node.left, data);
    } else if (data > node.data) {
      node.right = insert(node.right, data);
    }
    return node;
  }
}
