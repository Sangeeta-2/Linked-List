/*
i/p->1->2->3->4->5 and left=2 and right=4
o/p->1->4->3->2->5
 */
public class ReverseLinkedList2 {
    static class Node{
        int val;
        Node next;
        Node(int val){
            this.val=val;
            next=null;
        }
    }
    public Node reverse2(Node head,int left,int right){
        if (head == null || head.next == null || left == right) {
            return head;
        }

        // Create dummy node to handle edge case where left = 1
        Node dummy = new Node(0);
        dummy.next = head;

        // Step 1: Find the node just before the 'left' position
        Node prev1 = dummy;
        for (int i = 1; i < left; i++) {
            prev1 = prev1.next;
        }

        // Step 2: Start reversing from 'left' position
        Node curr = prev1.next;  // This is the node at 'left' position
        Node prev = null;
        Node next = null;

        // Step 3: Reverse nodes from 'left' to 'right' position
        for (int i = left; i <= right; i++) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        // Step 4: Connect the reversed portion back to the list
        // prev1.next was the first node of reversed portion, now it should point to last node of reversed portion
        Node firstNodeOfReversedPortion = prev1.next;
        firstNodeOfReversedPortion.next = curr;  // Connect to the node after 'right' position
        prev1.next = prev;  // Connect to the new first node of reversed portion

        return dummy.next;
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
        ReverseLinkedList2 obj=new ReverseLinkedList2();
        Node head=new Node(1);
        head.next=new Node(2);
        head.next.next=new Node(3);
        head.next.next.next=new Node(4);
        head.next.next.next.next=new Node(5);
        head.next.next.next.next.next=new Node(6);
        System.out.println("Printing actual Linked list");
        obj.display(head);
        int left=2,right=4;
        head=obj.reverse2(head,left,right);
        System.out.println("Printing reversed Linked list");
        obj.display(head);
    }
}
