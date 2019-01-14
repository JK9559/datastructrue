package com.wkang.ds;

import java.util.LinkedList;
import java.util.List;

/**
 * @author kangwei
 * @date 2018/12/21
 */
public class ListNode {
    private int val;
    private ListNode next;

    ListNode(int val) {
        this.val = val;
    }

    private static ListNode transfer(int[] num) {
        ListNode head = null;
        for (int i = 0; i < num.length; i++) {
            head = insert(head, num[i]);
        }
        return head;
    }

    private static ListNode insert(ListNode head, int ele) {
        ListNode cur = new ListNode(ele);

        ListNode tmp = head;
        if (head == null) {
            //cur.next = head;
            head = cur;
        } else {
            while (tmp.next != null) {
                tmp = tmp.next;
            }
            tmp.next = cur;
        }
        return head;
    }

    private static void display(ListNode head) {
        ListNode cur = head;
        List<Integer> list = new LinkedList<Integer>();
        while (null != cur) {
            list.add(cur.val);
            cur = cur.next;
        }
        System.out.println("List is : " + list);
    }

    private static ListNode reverseListNode(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prev = dummy.next;
        ListNode pCur = prev.next;
        while (pCur != null) {
            prev.next = pCur.next;
            pCur.next = dummy.next;
            dummy.next = pCur;
            pCur = prev.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        int[] num = {1, 2, 3, 4, 5, 6, 7};
        display(transfer(num));
        display(reverseListNode(transfer(num)));
    }
}
