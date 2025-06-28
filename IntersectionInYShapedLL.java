/*
Given two singly linked lists of size N and M, write a program to get the point where two linked lists intersect each other.
Example 1:
Input:
LinkList1 = 3 6 9 common
LinkList2 = 10 common
common = 15 30 NULL
Output: 15
getIntersectionPoint (Two Pointer Technique)
Time Complexity: O(m + n)
Sapce Complexity: O(1)
 */
public class IntersectionInYShapedLL {
    static class Node{
        int val;
        Node next;
        Node(int val){
            this.val=val;
            next=null;
        }
    }
    public int getIntersectionPoint(Node head1,Node head2){
        Node p1=head1;
        Node p2=head2;
        while(p1!=p2) {
            p1 = (p1 == null) ? head2 : p1.next;
            p2 = (p2 == null) ? head1 : p2.next;
        }
        return p1.val;
    }
    public static void main(String[] args){
        IntersectionInYShapedLL obj=new IntersectionInYShapedLL();
        Node common=new Node(15);
        common.next=new Node(30);
        Node head1=new Node(3);
        head1.next=new Node(6);
        head1.next.next=new Node(9);
        head1.next.next.next=common;
        Node head2=new Node(10);
        head2.next=common;
        System.out.println("The intersection point is at Node "+obj.getIntersectionPoint(head1,head2));
    }
}