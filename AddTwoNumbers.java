/*
You are given two non-empty linked lists representing two non-negative integers.
The digits are stored in reverse order, and each of their nodes contains a single digit.
Add the two numbers and return the sum as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.


Input: l1 = [2,4,3], l2 = [5,6,4]
Output: [7,0,8]
Explanation: 342 + 465 = 807.
Time Complexity: O(max(m, n))
Space Complexity: O(max(m, n))
 */
public class AddTwoNumbers {
    static class Node{
        int val;
        Node next;
        Node(int val){
            this.val=val;
            next=null;
        }
    }

    private Node addTwoNumbers(Node head1,Node head2){
        int carry=0;
        Node dummy=new Node(0);
        Node curr=dummy;
        while(head1!=null || head2!=null){
            int sum=carry;
            if(head1!=null){
                sum+=head1.val;
                head1=head1.next;
            }
            if(head2!=null){
                sum+=head2.val;
                head2=head2.next;
            }
            Node newNode=new Node(sum%10);
            curr.next=newNode;
            curr=curr.next;
            carry=sum/10;
        }
        if(carry!=0){
            Node newNode=new Node(carry);
            curr.next=newNode;
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
        AddTwoNumbers obj=new AddTwoNumbers();
        Node head1=new Node(2);
        head1.next=new Node(4);
        head1.next.next=new Node(3);

        Node head2=new Node(5);
        head2.next=new Node(6);
        head2.next.next=new Node(4);

        System.out.println("Adding two numbers");
        Node newHead=obj.addTwoNumbers(head1,head2);
        obj.display(newHead);


    }

}
