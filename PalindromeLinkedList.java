/*
Given a singly linked list of size N of integers. The task is to check if the given linked list is palindrome or not.

Example 1:

Input:
N = 3
value[] = {1,2,1}
Output: 1
Explanation: The given linked list is
1 2 1 , which is a palindrome and
Hence, the output is 1.
Example 2:

Input:
N = 4
value[] = {1,2,3,4}
Output: 0
Explanation: The given linked list
is 1 2 3 4 , which is not a palindrome
and Hence, the output is 0.

Expected Time Complexity: O(N)
Expected Auxialliary Space Usage: O(1)  (ie, you should not use the recursive stack space as well)
 */
public class PalindromeLinkedList {
    static class Node{
        int val;
        Node next;
        Node(int val){
            this.val=val;
            next=null;
        }
    }
    public boolean isPalindrome(Node head){
        Node curr=head;
        Node middleElement=getMiddleElement(head);
        Node last=reverseLL(middleElement);
        while(last!=null){
            if(curr.val==last.val){
                curr=curr.next;
                last=last.next;
            }else{
                return false;
            }
        }
        return true;
    }

    private Node getMiddleElement(Node head) {
        Node slow=head;
        Node fast=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
    private Node reverseLL(Node head){
        Node prev=null;
        Node next=null;
        Node curr=head;
        while(curr!=null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        return prev;
    }
    public static void main(String[] args){
        PalindromeLinkedList obj=new PalindromeLinkedList();
        Node head=new Node(1);
        head.next=new Node(2);
        head.next.next=new Node(1);
        System.out.println("Is the Linked List Palindrome? "+obj.isPalindrome(head));
        Node head1=new Node(1);
        head1.next=new Node(2);
        head1.next.next=new Node(3);
        head1.next.next.next=new Node(4);
        System.out.println("Is the Linked list Palindrome? "+obj.isPalindrome(head1));
    }
}
