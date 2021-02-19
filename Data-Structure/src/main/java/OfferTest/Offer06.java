package OfferTest;

import utils.ListNode;

/**
 *输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 示例 1：
 输入：head = [1,3,2]
 输出：[2,3,1]
 *
 * 方法:暴力
 */
public class Offer06 {
    public int[] reversePrint(ListNode head) {
        ListNode node=head;
        if (head==null){
            return new int[0];
        }
        int count=0;
        while (head!=null){
            count++;
            head=head.next;
        }
        int[] res=new int[count];
        for (int i = count-1; i >=0 ; i--) {
            res[i]=node.val;
            node=node.next;
        }
        return res;
    }

}
