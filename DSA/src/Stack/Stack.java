package Stack;
import java.util.ArrayList;

public class Stack {
     ArrayList<Integer> list = new ArrayList<>();

    public boolean isEmpty() {
        return list.size() == 0;
    }
    
    public int size()
    {
       return list.size();
    }

    public int peek() {
        if (list.size() == 0) return -1;
        return list.get(list.size() - 1);
    }

    public int pop() {
        if (list.size() == 0) return -1;
        
        int peek = list.get(list.size() - 1);
        list.remove(list.size() - 1);
        return peek;
    }

    public void push(int num) {
        list.add(num);
    }

    public void pushAtMid(Stack stack,int midElement)
    {
        insertAtMid(stack,midElement,0,stack.size()/2);
    }
    private void insertAtMid(Stack stack,int midElement,int index,int mid)
    {
        if(mid==index)
        {
            stack.push(midElement);
            return;
        }
        
        int num=stack.pop();
        insertAtMid(stack,midElement,index+1,mid);
        stack.push(num);
    }

    public void pushAtBottom(Stack stack,int newElement)
    {
        if(stack.isEmpty())
        {
            stack.push(newElement);
            return;
        }
        int temp=stack.pop();
        pushAtBottom(stack,newElement);
        stack.push(temp);
    }

}


class stack_operations {
    public static void main(String[] args)
    {
        Stack stack= new Stack();
        stack.push(1);
        stack.push(2);
        stack.push(4);
        stack.push(5);
        stack.pushAtMid(stack,3);
        System.out.println(stack.peek());
    }
}