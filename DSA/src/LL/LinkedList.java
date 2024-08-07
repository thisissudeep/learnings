package LL;
import Stack.Stack;

class Node
    {
    int data;
    Node next;
    Node(int data)
    {
       this.data=data;
    }
    Node(){};

}

public class LinkedList {
    
    private Node head;
    private Node tail;
    private int size=0;


    public Node buildLinkedList(int[] nums,int i)
    {
    if(i==nums.length) return null;
    Node newNode=new Node(nums[i]);
    newNode.next=buildLinkedList(nums,i+1);
    return newNode;
    }

    public void addLast(int item)
    {
        Node newNode=new Node(item);
        if(size==0)
        {
            tail=newNode;
            head=newNode;
            size++;
        }
        else
        {
            tail.next=newNode;
            tail=newNode;
            size++;
        }
    }

    public void addFirst(int item) {
        Node newNode = new Node(item);
        if (!isEmpty()) {
            newNode.next = this.head;
            this.head = newNode;
            size++;
        } else if (isEmpty()) {
            this.tail = newNode;
            this.head = newNode;
            size++;
        }
    }

    public void removeFirst() throws Exception{
        if (isEmpty()) throw new Exception("List is empty");
        else if (this.size == 1) {
            this.head = null;
            this.tail = null;
            this.size=0;
        }else {
            this.head = this.head.next;
            size--;
        }
    }

    public void removeLast() 
    {
        if(size==0)
        {
            return;
        }
        else if(size==1)
        {
            head=null;
            tail=null;
            size--;
        }
        else
        {
        Node curr=head;

        while(curr.next!=tail)
        {
            curr=curr.next;
        }
        curr.next=null;
        size--;
        }
        
    }

        public void removeAt(int i) throws Exception{
        if(isEmpty()) throw new Exception("List is empty");
        if(this.size==1){
            this.head=null;
            this.tail=null;
        }else {
            Node n1=getNodeAt(i-1);
            n1.next=getNodeAt(i+1);}
            size--;
        }

        public Node getNodeAt(int id) throws Exception{
            if (isEmpty()) throw new Exception("List is empty");
            if (id < 0 || id > this.size) System.out.println("Enter Between 0 to" + this.size);
            Node temp = this.head;
            for (int i = 0; i < id; i++) temp = temp.next;
            return temp;
        }

        public int getValueAt(int id) throws Exception{
            if (isEmpty()) throw new Exception("List is empty");
            if (id < 0 || id > this.size){
                System.out.println("Enter Between 0 to" + this.size);
                return -1;
            }
            else{
                Node temp = this.head;
                for (int i = 0; i < id; i++) temp = temp.next;
                return temp.data;
            }
        }
    
        public void reverse() throws Exception{
            Stack stack = new Stack();
            if (this.head == null) throw new Exception("List is empty");
            else {
                while (this.head != null) {
                    stack.push(this.head.data);
                    this.head = this.head.next;
                    this.size--;
                }
                while (!stack.isEmpty()) {
                    Node newNode =new Node(stack.pop());
                    
                    if (size >= 1) {
                        this.tail.next = newNode;
                        this.tail = newNode;
                        this.size++;
                    } else if (size == 0) {
                        this.tail = newNode;
                        this.head = newNode;
                        this.size++;
                    }
                }
            }
        }

   
    
        public int getFirstValue() throws Exception{
            if (isEmpty()) throw new Exception("List is empty");
            return this.head.data;
        }
    
        public int getLastValue() throws Exception{
            if (isEmpty()) throw new Exception("List is empty");
            return this.tail.data;
        }
    
        public void deleteMid() throws Exception {
            if(isEmpty()) throw new Exception("List is empty");
            else{
                removeAt(this.size/2);
            }
        }

    
        public void print(){print(head);}
        
        public void print(Node head) {
            if (head == null) return;
            System.out.print(head.data + " ");
            print(head.next);
          }

        public void reversePrint(Node head)
        {
          if(head==null) return ;
          reversePrint(head.next);
          System.out.print(head.data+" ");
        }

        public boolean isEmpty()
        {
            if(size==0) return true;
            else return false;
        }

        public boolean isPalindrome()
        {
            Stack stack=new Stack();
            Node temp=head;

            int index=0;
            while(index<size/2)
            {
                stack.push(temp.data);
                temp=temp.next;
                index++;
            }
            if(size%2!=0) temp=temp.next;

            while(!stack.isEmpty())
            {
                int lastElement=stack.pop();
                if(lastElement!=temp.data) return false;
                temp=temp.next;
            }
            return true;
            
        }
        

        // public void createPartitions(int k)                                            
        //   {
        //      Queue<Integer> smallList=new LinkedList<>();
        //      Queue<Integer> largeList=new LinkedList<>();
        //      Node curr=head;
        //      while(curr!=null)
        //      {
        //        if(curr.data<k) smallList.add(curr.data);
        //        else if(curr.data>=k) largeList.add(curr.data);
        //        curr=curr.next;
        //      }
        //      curr=null;
        //      while(!smallList.isEmpty())
        //      System.out.print(smallList.remove()+" ");
        //      while(!largeList.isEmpty())
        //      System.out.print(largeList.remove()+" ");
        //    }


        public int getReverseNum(){return getReverseNum(head);}
        private int getReverseNum(Node head)
        {
          if(head.next==null) return head.data;
          return (getReverseNum(head.next)*10)+head.data;
        }


    // public Node reverseList(Node head)   // Using Iterative
    // {
    //     Node newNode=null;
    //     Node temp;
    //     while(head!=null)
    //     {
    //         temp=head.next;
    //         head.next=newNode;
    //         newNode=head;
    //         head=temp;
    //     }
    //     return newNode;
    // }


        Node newNode;     // Using Recursion
        Node temp;
        public Node reverseList()
        {
            newNode=null; temp=null;
            return reverseList(head);
        }
        Node reverseList(Node head) 
        {
            
            if(head==null) return newNode;
            temp=head.next;
            head.next=newNode;
            newNode=head;
            head=temp;
            return reverseList(head);
        }
    
        
}



class ll_operations {
    public static void main (String[] args) throws Exception
    {
    
        LinkedList ll=new LinkedList();
        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(1);
    
         ll.print();
        // System.out.print(ll.isPalindrome());
      
    }
}