package OfferTest;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;
import utils.TreeNode;

/**
 * 输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
 *
 * B是A的子结构， 即 A中有出现和B相同的结构和节点值。
 *
 * 例如:
 * 给定的树 A:
 *
 *      3
 *     / \
 *    4   5
 *   / \
 *  1   2
 * 给定的树 B：
 *
 *    4 
 *   /
 *  1
 * 返回 true，因为 B 与 A 的一个子树拥有相同的结构和节点值。
 *
 * 示例 1：
 *
 * 输入：A = [1,2,3], B = [3,1]
 * 输出：false
 *
 * 方法:递归(两次)
 */
public class Offer26 {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A==null || B==null){
            return false;
        }
        //判断当前头结点的值与接下的值
        if (A.val==B.val && (helper(A.right,B.right) && helper(A.left,B.left)) ){
            return true;
        }
        //递归继续寻找
        return isSubStructure(A.left,B) || isSubStructure(A.right,B);
    }

    private boolean helper(TreeNode A, TreeNode B) {
        //先判断B在判断A
        //代表B已经梯归结束
        if (B==null){
            return true;
        }
        //代表B已经梯归结束
        if (A==null){
            return false;
        }
        //判断当前的值是否相等,相等继续递归
        if (A.val==B.val){
            return helper(A.left,B.left) && helper(A.right,B.right);
        }else{
            return false;
        }
    }
}
