/*
i/p->1->2->3->4
o/p->2->1->4->3
Time Complexity: O(n)
Spacce Complexity:O(1)
 */
public class SwapNodesInPairs {
    static class Node{
        int val;
        Node next;
        Node(int val){
            this.val=val;
            next=null;
        }
    }
    public Node swapNodesInPairs(Node head){
        Node dummy=new Node(0);
        dummy.next=head;
        Node prev=dummy;
        Node curr=head;
        while(curr!=null && curr.next!=null){
            Node first=curr;
            Node second =curr.next;
            first.next=second.next;
            second.next=first;
            prev.next=second;
            curr=first.next;
            prev=first;
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
        SwapNodesInPairs obj=new SwapNodesInPairs();
        Node head=new Node(1);
        head.next=new Node(2);
        head.next.next=new Node(3);
        head.next.next.next=new Node(4);
        System.out.println("Displaying the list before swap");
        obj.display(head);
        head=obj.swapNodesInPairs(head);
        System.out.println("Displaying the list after swap");
        obj.display(head);
    }
}
