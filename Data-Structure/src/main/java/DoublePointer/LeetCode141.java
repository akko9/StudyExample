package DoublePointer;

import utils.ListNode;



/**
难度:简单
给定一个链表，判断链表中是否有环。
如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
如果链表中存在环，则返回 true 。 否则，返回 false 。
来源：力扣（LeetCode）
方法:快慢双指针
 list={4,5,6,7}  res=false
 */
public class LeetCode141 {
    public boolean hasCycle(ListNode head) {
        if (head==null){
            return false;
        }
        //快慢指针的起点相同
       ListNode slow=head;
       ListNode fast=head;
       //fast!=null 成立跳出循环 fast.next != null 防止循环中的 fast=fast.next为null 导致fast.next.next 空指针
       while (fast!=null &&fast.next != null){
           slow=slow.next;
           fast=fast.next.next;
           //判断slow与fast地址是否相同,相同为环
           if (slow==fast){
               return true;
           }
       }
       //跳出说明有终点
        return false;
    }
}
