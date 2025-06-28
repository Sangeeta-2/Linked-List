/*
Given a linked list. Task is find if it has loop or not.
isLoopPresent (Floyd's Cycle Detection Algorithm)
Time Complexity: O(n)
Space Complexity: O(1)
 */
public class DetectLoopInLinkedList {
    static class Node{
        int val;
        Node next;
        Node(int val){
            this.val=val;
            next=null;
        }
    }
    public boolean isLoopPresent(Node head){
        Node slow=head;
        Node fast=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast){
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args){
        DetectLoopInLinkedList obj=new DetectLoopInLinkedList();
        Node head=new Node(2);
        head.next=new Node(3);
        head.next.next=new Node(7);
        head.next.next.next=new Node(9);
        head.next.next.next.next=new Node(6);
        head.next.next.next.next.next=head.next;
        System.out.println("Is the linked list contains loop? "+obj.isLoopPresent(head));
    }


}
