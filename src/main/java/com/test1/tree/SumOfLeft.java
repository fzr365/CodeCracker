package com.test1.tree;

import com.sun.source.tree.Tree;

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode (){};
    TreeNode(int val) { this.val=val;}
    TreeNode(int val,TreeNode left,TreeNode right){
        this.val=val;
        this.left=left;
        this.right=right;
    }
}
public class SumOfLeft {
    int sum=0;
    public int sumOfLeft(TreeNode root){
        if(root==null){
            return 0;
        }
        //树为空就直接返回0
        if(root.left!=null&&root.left.left==null&&root.left.right==null){
            sum+=root.left.val;
        }
        sumOfLeft(root.left);
        sumOfLeft(root.right);
        return sum;
    }

    public static void main(String[] args) {
         TreeNode root=new TreeNode(3);
         root.left =new TreeNode(9);
         root.right=new TreeNode(20);
         root.right.left=new TreeNode(15);
         root.right.right=new TreeNode(7);

         SumOfLeft solution=new SumOfLeft();
         int result=solution.sumOfLeft(root);
         System.out.println(result);
    }
}
