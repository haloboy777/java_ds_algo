package dev.ayushsingh.tree;

public class BSTNode {

  public int data;
  public BSTNode left, right;

  public BSTNode(int data) {
    this.data = data;
    left = null;
    right = null;
  }

  public BSTNode insert(BSTNode node, int data) {
    if (node == null) {
      return new BSTNode(data);
    } else if (data < node.data) {
      node.left = insert(node.left, data);
    } else if (data > node.data) {
      node.right = insert(node.right, data);
    }
    return node;
  }
}
