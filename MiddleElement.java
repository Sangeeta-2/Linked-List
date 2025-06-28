/*
Given a singly linked list of N nodes.
The task is to find the middle of the linked list. For example, if the linked list is
1- 2-3-4-5, then the middle node of the list is 3.
If there are two middle nodes(in case, when N is even), print the second middle element.
For example, if the linked list given is 1-2-3-4-5-6, then the middle node of the list is 4.

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(1)
 */
public class MiddleElement {
    static class Node{
        int val;
        Node next;
        Node(int val){
            this.val=val;
            next=null;
        }
    }
    public int getMiddleElement(Node head){
        Node slow=head;
        Node fast=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow.val;
    }
    public static void main(String[] args){
        MiddleElement obj=new MiddleElement();
        Node head1=new Node(1);
        head1.next=new Node(2);
        head1.next.next=new Node(3);
        head1.next.next.next=new Node(4);
        head1.next.next.next.next=new Node(5);
        System.out.println("The middle element of odd number of Nodes is "+obj.getMiddleElement(head1));
        Node head2=new Node(1);
        head2.next=new Node(2);
        head2.next.next=new Node(3);
        head2.next.next.next=new Node(4);
        head2.next.next.next.next=new Node(5);
        head2.next.next.next.next.next=new Node(6);
        System.out.println("The middle element of even number of Nodes is "+obj.getMiddleElement(head2));
    }
}
