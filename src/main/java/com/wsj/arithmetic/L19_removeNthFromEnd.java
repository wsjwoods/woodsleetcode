package com.wsj.arithmetic;

import com.wsj.common.ListNode;

/**
 * @author wushijian
 * @date 2020/7/31 15:01
 *
 * 19. 删除链表的倒数第N个节点
 *
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 *
 * 示例：
 *
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 *
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * 说明：
 *
 * 给定的 n 保证是有效的。
 *
 * 进阶：
 *
 * 你能尝试使用一趟扫描实现吗？
 */
public class L19_removeNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int p=0,q=0;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pNode = dummy;
        ListNode qNode = dummy;

        while (true){
            if(p+n == q){
                p++;
                q++;
                if(qNode.next == null){
                    pNode.next = pNode.next.next;
                    break;
                }
                pNode = pNode.next;
                qNode = qNode.next;
            }else{
                qNode = qNode.next;
                q++;
            }
        }
        return dummy.next;
    }
}
