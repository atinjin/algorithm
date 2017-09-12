package com.github.atinjin.algorithm.tree;

public class TreeInorderTraversal {
    public static void main(String[] args) {
        BinaryTreeNode root = new BinaryTreeNode(0);
        BinaryTreeNode n1 = new BinaryTreeNode(2);
        BinaryTreeNode n2 = new BinaryTreeNode(1);
        BinaryTreeNode n3 = new BinaryTreeNode(3);
        BinaryTreeNode n4 = new BinaryTreeNode(5);
        BinaryTreeNode n5 = new BinaryTreeNode(4);
        BinaryTreeNode n6 = new BinaryTreeNode(6);

        /**
         *         ROOT
         *        __⏊___
         *     n1        n4
         *  n2    n3   n5   n6
         *
         */
        root.left = n1;
        n1.left = n2;
        n1.right = n3;
        root.right = n4;
        n4.left = n5;
        n4.right = n6;

        inorderTraversal(root);
    }

    static void inorderTraversal(BinaryTreeNode root) {
        if(root == null) return;

        inorderTraversal(root.left);
        System.out.println(root.data);
        inorderTraversal(root.right);
    }

}