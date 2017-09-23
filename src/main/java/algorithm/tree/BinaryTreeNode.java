package com.github.atinjin.algorithm.tree;

/**
 * Created by ryanjin on 29/11/2016.
 */
public class BinaryTreeNode {
    BinaryTreeNode(int data) {this.data = data;}

    int data;
    BinaryTreeNode left;
    BinaryTreeNode right;

    public void putBST(BinaryTreeNode n2) {
        if(n2.data < this.data) {
            if(this.left != null)
                this.left.putBST(n2);
            else
                this.left = n2;
        } else {
            if(this.right != null)
                this.right.putBST(n2);
            else
                this.right = n2;
        }
    }

    public BinaryTreeNode getLargest() {
        if(this.right != null)
            return this.right.getLargest();
        else
            return this;
    }
}
