/*
Given the head of a singly linked list,
group all the nodes with odd indices together followed by the nodes with even indices and return the list.
The first node is considered odd and the seconbd is considered as even and so on
TC->O(n)
SC->O(1)
 */
public class OddEvenLinkedList {
    static class Node{
        int val;
        Node next;
        Node(int val){
            this.val=val;
            next=null;
        }
    }
    private Node oddEven(Node head){
        Node oddNode=head;
        Node evenHead=head.next;
        Node evenNode=head.next;
        while(evenNode!=null&& evenNode.next!=null){
            oddNode.next=evenNode.next;
            oddNode=oddNode.next;
            evenNode.next=oddNode.next;
            evenNode=evenNode.next;
        }
        oddNode.next=evenHead;
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
        OddEvenLinkedList obj=new OddEvenLinkedList();
        Node head=new Node(1);
        head.next=new Node(2);
        head.next.next=new Node(3);
        head.next.next.next=new Node(4);
        head.next.next.next.next=new Node(5);
        System.out.println("Displaying Linked list before odd even");
        obj.display(head);
        head=obj.oddEven(head);
        System.out.println("Displaying Linked list after odd even");
        obj.display(head);


    }

}
