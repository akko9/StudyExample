package OfferTest;

import utils.TreeNode;

/**
 * 输入一棵二叉树的根节点，判断该树是不是平衡二叉树。如果某二叉树中任意节点的左右子树的深度相差不超过1，那么它就是一棵平衡二叉树。
 *
 *  
 *
 * 示例 1:
 *
 * 给定二叉树 [3,9,20,null,null,15,7]
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 */
public class Offer55Two {
    public boolean isBalanced(TreeNode root) {
        if (root==null){
            return true;
        }
     return Math.abs(getDept(root.left) - getDept(root.right)) <= 1
             && isBalanced(root.left) && isBalanced(root.right);

    }

    private int getDept(TreeNode root) {
        if (root==null){
            return 0;
        }
        int left = getDept(root.left);
        int right = getDept(root.right);
        return Math.max(left,right)+1;
    }
}
