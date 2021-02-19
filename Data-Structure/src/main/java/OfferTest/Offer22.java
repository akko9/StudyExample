package OfferTest;

import utils.ListNode;

/**
 * 输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。
 *
 * 例如，一个链表有 6 个节点，从头节点开始，它们的值依次是 1、2、3、4、5、6。这个链表的倒数第 2 个节点是值为 4 的节点。
 *
 * 示例：
 * 给定一个链表: 1->2->3->4->5, 和 k = 2.
 * 返回链表 4->5.
 *
 * 方法:暴力
 * 方法二:双指针
 */
public class Offer22 {
    public ListNode getKthFromEnd(ListNode head, int k) {
        if (head==null){
            return null;
        }
        //设置两个快慢节点
        ListNode slow=head;
        ListNode fast=head;
        int index=1;
        //快节点先走k步
        while (index<=k){
            index++;
            fast=fast.next;
        }
        //快慢节点一起走,直到快节点结束
        while (fast!=null){
            slow=slow.next;
            fast=fast.next;
        }
        return slow;
    }

    public ListNode getListNode1(ListNode head, int k) {
        if (head==null){
            return null;
        }
        ListNode node=head.next;
        ListNode realNode=head;
        int count=1;
        int index=1;
        while (node!=null){
            count++;
            node=node.next;
        }
        while (index<=count-k){
            index++;
            realNode=realNode.next;
        }
        return realNode;
    }
}
