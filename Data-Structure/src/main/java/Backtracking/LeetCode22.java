package Backtracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 * 方法:回溯
 *
 * 输入：n = 3
 * 输出：["((()))","(()())","(())()","()(())","()()()"]
 */
public class LeetCode22 {
    public static List<String> generateParenthesis(int n) {
        List<String> res=new ArrayList<String>();
        //边界值
        if (n==0){
            return null;
        }
        String str="";
        getBrackets(n,res,0,0,str);
        return res;
    }

    /**
     *
     * @param n 传入括号次数
     * @param res 返回结果集合
     * @param left 左括号个数
     * @param right 右括号个数
     * @param str 要传入list的结果
     */
    public static void getBrackets(int n, List<String> res, int left, int right,String str){
        //判断left<right 说明生成的括号错误
        if (left<right){
            return;
        }
        //如果生成的左,右括号为n个 生成成功,将该值存入res
        if (left==right&&left==n){
            res.add(str);
        }
        //如果左括号小于n,表示还可以继续添加(
        if (left<n){
            getBrackets(n,res,left+1,right,str+"(");
        }
        //如果左括号个数大于右括号,可以添加右括号
        if (left>right){
            getBrackets(n,res,left,right+1,str+")");
        }
    }

    public static void main(String[] args) {
        List<String> list = generateParenthesis(4);
        System.out.println(list);

    }
}
