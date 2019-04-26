package com.wsj;

import com.wsj.common.ListNode;

/**
 * 反转一个单链表。
 *
 * 示例:
 *
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * 进阶:
 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 */
public class reverseList {
    public ListNode reverseList(ListNode head) {
        ListNode res = null;
        ListNode cur = head;
        ListNode tmp;
        while (cur!=null)
        {
            tmp = cur.next;
            cur.next = res;
            res = cur;
            cur = tmp;
        }
        return res;
    }
}
