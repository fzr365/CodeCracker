package com.test1.list;
// 定义单链表节点类
//class ListNode {
//    int val;
//    ListNode next;
//    ListNode() {}
//    ListNode(int val) { this.val = val; }
//    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
//}

// 定义解决方案类
class KOne {
    public ListNode reverseKGroup(ListNode head, int k) {
        // 哨兵节点
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        // 两个节点一起从哨兵位置出发
        ListNode pre = dummy;
        ListNode end = dummy;

        while (end.next != null) {
            for (int i = 0; i < k && end != null; i++) {
                end = end.next;
            }
            if (end == null) {
                break;
            }
            ListNode start = pre.next;
            ListNode next = end.next;
            end.next = null;
            pre.next = reverse(start);
            start.next = next;
            pre = start;

            end = pre;
        }
        return dummy.next;
    }

    private ListNode reverse(ListNode head) {
        // 前后节点
        ListNode pre = null;
        ListNode cur = head;
        // 翻转相邻节点
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        // pre代表最后一个节点
        return pre;
    }

    public static void main(String[] args) {
        // 构建链表 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        KOne solution = new KOne();
        int k = 2;
        ListNode result = solution.reverseKGroup(head, k);

        // 打印结果链表
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }
}


