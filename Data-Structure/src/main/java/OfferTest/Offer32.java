package OfferTest;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其层次遍历结果：
 *
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 *
 * 方法:递归
 */
public class Offer32 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root==null){
            return new ArrayList<List<Integer>>();
        }
        List<List<Integer>> res=new ArrayList<List<Integer>>();
        print(root,res,0);
        return res;
    }
    public void print(TreeNode root,List<List<Integer>> res,int dept){
        if (root==null){
            return ;
        }
        if (res.size()==dept){
            //每下一层,新建一个ArrayList
            System.out.println(res.size());
            res.add(new ArrayList<Integer>());
        }
        //那一层的数放入哪一个下标下的ArrayList
        res.get(dept).add(root.val);
        print(root.left,res,dept+1);
        print(root.right,res,dept+1);
    }
}
