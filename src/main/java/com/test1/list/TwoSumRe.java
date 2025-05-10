package com.test1.list;

import java.util.List;

class ListNode{
    int val;
    ListNode next;
    ListNode(){}
    ListNode(int val){this.val=val;}
    ListNode(int val,ListNode next){this.val=val;this.next=next;}
}
class TwoSumRe {
     public ListNode addTwoNum(ListNode l1,ListNode l2){
         ListNode dummy=new ListNode(0);
         ListNode cur=dummy;
         int carry=0;
         while(l1!=null||l2!=null){
             int x=l1==null?0:l1.val;
             int y=l2==null?0:l2.val;
             int sum=x+y+carry;

             carry=sum/10;
             sum=sum%10;

             cur.next=new ListNode(sum);

             cur=cur.next;

             if(l1!=null) l1=l1.next;
             if(l2!=null) l2=l2.next;
         }

         //还有进位
         if(carry==1){
             cur.next=new ListNode(carry);
         }
         return dummy.next;
     }

    public static void main(String[] args) {
        ListNode l1=new ListNode(2);
        l1.next=new ListNode(4);
        l1.next.next=new ListNode(3);

        ListNode l2=new ListNode(5);
        l2.next=new ListNode(6);
        l2.next.next=new ListNode(4);

        TwoSumRe twoSumRe =new TwoSumRe();
        ListNode result=twoSumRe.addTwoNum(l1,l2);

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




























