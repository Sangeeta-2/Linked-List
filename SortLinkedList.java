/*
Time Complexity: O(n log n)
Space Complexity->O(log n)
 */
public class SortLinkedList {
    static class Node{
        int val;
        Node next;
        Node(int val){
            this.val=val;
            next=null;
        }
    }
    private Node mergeSort(Node head){
        if (head == null || head.next == null) {
            return head;
        }
        Node middleNode=getMidNode(head);
        Node rightNodeStart=middleNode.next;
        middleNode.next=null;// to break it into two separate halves
        Node left=mergeSort(head);
        Node right=mergeSort(rightNodeStart);
        return merge(left,right);
    }
    private Node merge(Node list1, Node list2){
        Node dummy=new Node(0);
        Node curr=dummy;
        while(list1!=null && list2!=null){
            if(list1.val<list2.val){
                curr.next=new Node(list1.val);
                list1=list1.next;
            }else{
                curr.next=new Node(list2.val);
                list2=list2.next;
            }
            curr=curr.next;
        }
        if(list1!=null){
            curr.next=list1;
        }
        if(list2!=null){
            curr.next=list2;
        }
        return dummy.next;
    }

    private Node getMidNode(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node slow = head;
        Node fast = head;
        Node prev = null;

        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        return prev; // Return node before middle for proper split
    }
    public void display(Node head){
        Node curr=head;
        while(curr!=null){
            System.out.print(curr.val+"->");
            curr=curr.next;
        }
        System.out.println("Null");
    }

    public static void main(String[] args) {
        SortLinkedList obj = new SortLinkedList();

        // Create unsorted list: 4 -> 2 -> 1 -> 3 -> 5
        Node head = new Node(4);
        head.next = new Node(2);
        head.next.next = new Node(1);
        head.next.next.next = new Node(3);
        head.next.next.next.next = new Node(5);

        System.out.println("Original list:");
        obj.display(head);

        // Sort the list
        Node sortedHead = obj.mergeSort(head);
        System.out.println("Sorted list:");
        obj.display(sortedHead);
        // Expected output: 1 -> 2 -> 3 -> 4 -> 5
    }
}
