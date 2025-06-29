public class RotateLinkedList {
    static class Node{
        int val;
        Node next;
        Node(int val){
            this.val=val;
            next=null;
        }
    }
    private Node rotateLL(Node head,int k){
        if(head==null || head.next==null ||k==0){
            return head;
        }
        Node temp=head;
        int length=0;
        while(temp!=null){
            temp=temp.next;
            length++;
        }
        k=k%length;
        Node slow=head;
        Node fast=head;
        for(int i=0;i<k;i++){
            fast=fast.next;
        }
        while(fast.next!=null){
            slow=slow.next;
            fast=fast.next;
        }
        Node newHead=slow.next;
        fast.next=head;
        slow.next=null;
        return newHead;
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
        RotateLinkedList obj=new RotateLinkedList();
        Node head=new Node(1);
        head.next=new Node(2);
        head.next.next=new Node(3);
        head.next.next.next=new Node(4);
        head.next.next.next.next=new Node(5);
        int k=2;
        obj.display(head);
        head=obj.rotateLL(head,k);
        obj.display(head);

    }

}
