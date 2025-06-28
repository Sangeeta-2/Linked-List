/*
Given a linked list of N nodes. The task is to reverse this list.

Example 1:

Input:
LinkedList: 1-2-3-4-5-6
Output: 6 5 4 3 2 1
Explanation:

After reversing the list,
elements are 6-5-4-3-2-1.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(1).
 */
public class ReverseLL {
    static class Node{
        int val;
        Node next;
        Node(int val){
            this.val=val;
            next=null;
        }
    }
    public Node reverse(Node head){
        if(head==null || head.next==null){
            return head;
        }
        Node curr=head;
        Node next=null;
        Node prev=null;
        while(curr!=null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        return prev;
    }
    public void display(Node head){
        Node curr=head;
        while(curr!=null){
            System.out.print(curr.val+"->");
            curr=curr.next;
        }
        System.out.println("Null");
    }
    public static void main(String args[]){
        ReverseLL obj=new ReverseLL();
        Node head=new Node(1);
        head.next=new Node(2);
        head.next.next=new Node(3);
        head.next.next.next=new Node(4);
        head.next.next.next.next=new Node(5);
        head.next.next.next.next.next=new Node(6);
        System.out.println("Printing actual Linked list");
        obj.display(head);
        head=obj.reverse(head);
        System.out.println("Printing reversed Linked list");
        obj.display(head);
    }
}
