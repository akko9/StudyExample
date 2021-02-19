package OfferTest;

import utils.ListNode;

/**
 * 输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
 *
 * 示例1：
 *
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/he-bing-liang-ge-pai-xu-de-lian-biao-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Offer25 {
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode node=new ListNode(0);
        ListNode temp=node;
        while (l1!=null&&l2!=null){
            if (l1.val<=l2.val){
                temp.next=l1;
                l1=l1.next;
            }else{
                temp.next=l2;
                l2=l2.next;
            }
            temp=temp.next;
        }
//        while (l1!=null){
//            temp.next=l1;
//            l1=l1.next;
//            temp=temp.next;
//        }
//        while (l2!=null){
//            temp.next=l2;
//            l2=l2.next;
//            temp=temp.next;
//        }
        temp.next = l1 != null ? l1 : l2;
        return node.next;
    }

    public static void main(String[] args) {
        ListNode node1=new ListNode(-9);
        ListNode node2=new ListNode(3);
        //ListNode node3=new ListNode(4);
        node1.next=node2;
        //node2.next=node3;
        ListNode root1=new ListNode(5);
        ListNode root2=new ListNode(7);
        //ListNode root3=new ListNode(3);
        root1.next=root2;
        //root2.next=root3;
        ListNode node = mergeTwoLists(node1, root1);
        while (node1!=null){
            System.out.print("->"+node1.val);
            node1=node1.next;
        }
    }
}
