package com.test1.list;

import java.util.Stack;

public class TwoSumStack {
    public ListNode addTwoNumbers(ListNode l1,ListNode l2){
        Stack<Integer> stack1=new Stack<>();
        Stack<Integer> stack2=new Stack<>();

        while(l1!=null){
            stack1.push(l1.val);
            l1=l1.next;
        }
        while(l2!=null){
            stack2.push(l2.val);
            l2=l2.next;
        }
        int carry=0;
        ListNode dummy=null;
        while(!stack1.isEmpty()||!stack2.isEmpty()||carry!=0){
            int sum=carry;
            if(!stack1.isEmpty()){
                sum+=stack1.pop();
            }
            if(!stack2.isEmpty()){
                sum+=stack2.pop();
            }
            carry=sum/10;
            sum=sum%10;
            ListNode newNode=new ListNode(sum);
            newNode.next=dummy;
            dummy=newNode;
        }

        return dummy;
    }

    public static void main(String[] args) {
        ListNode l1=new ListNode(2);
        l1.next=new ListNode(4);
        l1.next.next=new ListNode(3);

        ListNode l2=new ListNode(5);
        l2.next=new ListNode(6);
        l2.next.next=new ListNode(4);

        TwoSumStack twoSumStack =new TwoSumStack();
        ListNode result=twoSumStack.addTwoNumbers(l1,l2);

        //输出结果
        while(result!=null){
            System.out.print(result.val);
            if(result.next!=null){
                System.out.print("->");
            }
            result=result.next;
        }
    }
}
