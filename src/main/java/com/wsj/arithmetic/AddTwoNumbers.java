package com.wsj.arithmetic;

import com.wsj.common.ListNode;

/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 *
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 示例：
 *
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 */
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int x = 0;
        int x1 = 0;//两数相加--个位
        int x2 = 0;//两数相加--十位
        ListNode temp = new ListNode(0);//初始化ListNode
        ListNode result = temp;//定义对象  引用 temp
        while(l1 != null || l2 != null){
            x = ((l1 == null) ? 0 : l1.val) + ((l2 == null) ? 0 : l2.val) + x2;//两数和的个位+上步运算的进位（0或1）
            x1 = x%10;//x的个位
            x2 = x/10;//x的十位（进位）
            temp.next = new ListNode(x1);//temp的下一位=x1
            temp = temp.next;//temp向后挪动指针
            if(l1 != null) l1 = l1.next;
            if(l2 != null) l2 = l2.next;
        }
        if(x2 != 0) temp.next = new ListNode(x2);

        return result.next;//返回初始化0的下一位开始
    }

}
