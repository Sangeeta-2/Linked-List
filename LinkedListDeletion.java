/*
Given a single Linked List and an integer x, delete xth node from the single Linked List.
1-based indexing
I/p->2->3->7->9->6, x=3
o/p-> 2-><3->9->6

 */
public class LinkedListDeletion {
    static class Node{
        int val;
        Node next;
        Node(int val){
            this.val=val;
            next=null;
        }

    }
    public Node deleteNode(Node head,int pos){
        Node curr=head;
        Node prev=null;
        int index=1;
        if(head==null){
            return null;
        }
        else if(pos==1){
            head=head.next;
            return head;
        }
        else{
            while(curr.next!=null && index!=pos){
                prev=curr;
                curr=curr.next;
                index++;
            }
            if(index==pos){
                prev.next=curr.next;
                return head;
            }else{
                System.out.println("The index is not present in the given linked list");
                return head;
            }
        }
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
        LinkedListDeletion obj=new LinkedListDeletion();
        Node head=new Node(2);
        head.next=new Node(3);
        head.next.next=new Node(7);
        head.next.next.next=new Node(9);
        head.next.next.next.next=new Node(6);
        System.out.println("Displaying before deletion");
        obj.display(head);
        System.out.println("Displaying after deletion");
        head=obj.deleteNode(head,3);
        obj.display(head);
        System.out.println("Displaying after deletion");
        head=obj.deleteNode(head,1);
        obj.display(head);

    }

}
