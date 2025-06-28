/*
One occurence of duplicate will be there
i/p->1->2->3->3->4->4->5
o/p->1->2->3->4->5
removeDuplicate1 (Remove Duplicates from Sorted Linked List)
Time Complexity: O(n)
Space Complexity: O(1)
 */
public class RemoveDuplicatesFromSortedLLPart1 {
    static class Node{
        int val;
        Node next;
        Node(int val){
            this.val=val;
            next=null;
        }
    }
    public Node removeDuplicate1(Node head){
        Node curr=head;
        while(curr.next!=null){
            if(curr.val==curr.next.val){
                curr.next=curr.next.next;
            }else{
                curr=curr.next;
            }
        }
        return head;
    }
    public void display(Node head){
        Node curr=head;
        while(curr!=null){
            System.out.print(curr.val+"->");
            curr=curr.next;
        }
        System.out.println("Null");
    }
    public static void main(String[] args){
        RemoveDuplicatesFromSortedLLPart1 obj=new RemoveDuplicatesFromSortedLLPart1();
        Node head=new Node(1);
        head.next=new Node(2);
        head.next.next=new Node(3);
        head.next.next.next=new Node(3);
        head.next.next.next.next=new Node(4);
        head.next.next.next.next.next=new Node(4);
        head.next.next.next.next.next.next=new Node(5);
        System.out.println("displaying actual Linked list");
        obj.display(head);
        head=obj.removeDuplicate1(head);
        System.out.println("Removing duplicates from Linked list");
        obj.display(head);
    }
}
