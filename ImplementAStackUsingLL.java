public class ImplementAStackUsingLL {
    static class Node{
        int val;
        Node next;
        Node(int val){
            this.val=val;
            next=null;
        }
    }
    private Node top=null;
    private void push(int val){
        Node newNode=new Node(val);
        newNode.next=top;
        top=newNode;
    }
    private int pop(){
        if(isEmpty()){
            throw new IllegalStateException("Stack is empty");
        }
        Node node=top;
        top=top.next;
        return node.val;
    }
    private boolean isEmpty(){
        if(top==null){
            return true;
        }else{
            return false;
        }
    }
    public void display(){
        Node curr=top;
        while(curr!=null){
            System.out.print(curr.val+"->");
            curr=curr.next;
        }
        System.out.println("Null");
    }
    public static void main(String[]args){
        ImplementAStackUsingLL stack=new ImplementAStackUsingLL();
        stack.push(2);
        stack.push(3);
        stack.push(7);
        stack.push(9);
        stack.push(6);
        System.out.println("Contents of stack");
        stack.display();
        System.out.println("The popped item is "+stack.pop());
        System.out.println("The popped item is "+stack.pop());
        System.out.println("Contents of stack");
        stack.display();
    }

}
