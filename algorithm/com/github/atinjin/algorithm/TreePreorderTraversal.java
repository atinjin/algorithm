package com.github.atinjin.algorithm;

public class TreePreorderTraversal {
    public static void main(String[] args) {
        BinaryTreeNode root = new BinaryTreeNode(0);
        BinaryTreeNode n1 = new BinaryTreeNode(1);
        BinaryTreeNode n2 = new BinaryTreeNode(2);
        BinaryTreeNode n3 = new BinaryTreeNode(3);
        BinaryTreeNode n4 = new BinaryTreeNode(4);
        BinaryTreeNode n5 = new BinaryTreeNode(5);
        BinaryTreeNode n6 = new BinaryTreeNode(6);

        root.left = n1;
        n1.left = n2;
        n1.right = n3;
        root.right = n4;
        n4.left = n5;
        n4.right = n6;

        preorderTraversal(root);
    }

    static void preorderTraversal(BinaryTreeNode root) {
        if(root == null) return;

        System.out.println(root.data);
        preorderTraversal(root.left);
        preorderTraversal(root.right);
    }

}