package com.github.atinjin.algorithm.tree;

/**
 * Created by ryanjin on 29/11/2016.
 */
public class SecondLargesValueInBST {

    public static void main(String[] args) {

        BinaryTreeNode n1 = new BinaryTreeNode(5);//1

        BinaryTreeNode root = n1;

        root.putBST(new BinaryTreeNode(3));//2
        BinaryTreeNode n8 = new BinaryTreeNode(8);
        root.putBST(n8);//2
        BinaryTreeNode n12 = new BinaryTreeNode(12);
        n8.putBST(n12);//3
        BinaryTreeNode n10 = new BinaryTreeNode(10);
        n12.putBST(n10);//4
        n10.putBST(new BinaryTreeNode(9));//5
        n10.putBST(new BinaryTreeNode(11));//5

        BinaryTreeNode node = find2ndLargest(root);
        if(node != null)
            System.out.println(node.data);
        else
            System.out.println("No 2nd largest node");

        int height = findHeight(root);
        System.out.println("Height is "+ height);
    }

    private static int findHeight(BinaryTreeNode root) {
        //base case
        //recursion
        int left = (root.left != null)?findHeight(root.left):0;
        int right = (root.right != null)?findHeight(root.right):0;
        if(left > right)
            return left+1;
        else
            return right+1;

    }

    private static BinaryTreeNode find2ndLargest(BinaryTreeNode root) {
        if(root.right == null) {
            if (root.left != null)
                return root.left;
            else
                return null;
        }

        BinaryTreeNode cache = root;
        BinaryTreeNode iter = root.right;
        while(true) {
           if(iter.right != null) {
               BinaryTreeNode right = iter.right;
               cache = iter;
               iter = right;
           } else
               break;
        }

        if(iter.left != null) {
            BinaryTreeNode leftLargestNode = iter.left.getLargest();
            cache = leftLargestNode;
        }

        return cache;
    }

}
