/*
No occurence of duplicate will be there
i/p->1->2->3->3->4->4->5
o/p->1->2->5
removeDuplicate1 (Remove Duplicates from Sorted Linked List)
Time Complexity: O(n) Outer while loop: traverses the list once, O(n)
Inner while loop: skips over duplicate values
Combined: each node is visited at most twice (once in outer loop, once in inner loop)
All pointer operations are O(1)
Overall: O(n) where n is the number of nodes
Space Complexity: O(1)
 */public class RemoveDuplicatesFromSortedLLPart2 {
    static class Node{
        int val;
        Node next;
        Node(int val){
            this.val=val;
            next=null;
        }
    }
    public Node removeDuplicates2(Node head){
        Node dummy=new Node(0);
        dummy.next=head;
        Node prev=dummy;
        Node curr=head;
        while(curr.next!=null){
            while(curr.val==curr.next.val){
                curr=curr.next;
            }
            if(prev.next==curr){
                prev=curr;
                curr=curr.next;
            }else{
                prev.next=curr.next;
                curr=curr.next;
            }
        }
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
    public static void main(String[] args){
        RemoveDuplicatesFromSortedLLPart2 obj=new RemoveDuplicatesFromSortedLLPart2();
        Node head=new Node(1);
        head.next=new Node(2);
        head.next.next=new Node(3);
        head.next.next.next=new Node(3);
        head.next.next.next.next=new Node(4);
        head.next.next.next.next.next=new Node(4);
        head.next.next.next.next.next.next=new Node(5);
        System.out.println("displaying actual Linked list");
        obj.display(head);
        head=obj.removeDuplicates2(head);
        System.out.println("Removing duplicates from Linked list");
        obj.display(head);

    }

}
