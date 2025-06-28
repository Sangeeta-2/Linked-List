/*
insertAtBeginning
Time Complexity: O(1)
Space Complexity: O(1)
insertAtEnd
Time Complexity: O(n)
Space Complexity: O(1)
 */
public class LinkedListInsertion {
    static class Node{
        int val;
        Node next;
        Node(int val){
            this.val=val;
            next=null;
        }
    }

    public Node insertAtBegining(int val,Node head){
        Node newNode=new Node(val);
        newNode.next=head;
        head=newNode;
        return head;
    }
    public Node insertAtEnd(int val,Node head){
        Node newNode=new Node(val);
        if(head==null){
            head=newNode;
        }else{
            Node curr=head;
            while(curr.next!=null){
                curr=curr.next;
            }
            curr.next=newNode;
        }
        return head;
    }
    public void display(Node head){
        Node curr=head;
        while(curr!=null){
            System.out.print(curr.val+"-> ");
            curr=curr.next;
        }
        System.out.println("Null");
    }

    public static void main(String[] args){
        LinkedListInsertion obj=new LinkedListInsertion();
        Node head=new Node(3);
        System.out.println("Displaying contents of the linked List so far:-");
        obj.display(head);
        head=obj.insertAtBegining(2,head);
        head=obj.insertAtBegining(1,head);
        System.out.println("Displaying contents of the linked List so far:-");
        obj.display(head);
        head=obj.insertAtEnd(4,head);
        head=obj.insertAtEnd(5,head);
        System.out.println("Displaying contents of the linked List so far:-");
        obj.display(head);
    }
}

