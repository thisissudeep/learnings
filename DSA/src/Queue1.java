import java.util.LinkedList;
import java.util.Queue;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class Queue1
 {
    public  static void queueReverseUptoK(Queue<Integer> queue,int k)
    {
        List<Integer> list=new ArrayList<>();
        while(k!=0)
        {
            list.add(queue.remove());
            k--;
        }
        Collections.reverse(list);

        while(!queue.isEmpty())
        {
            list.add(queue.remove());
        }
        for(int element:list)
        {
            System.out.print(element);
        }
    }
    public static void main(String[] args)
    {
        Queue<Integer> queue=new LinkedList<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queueReverseUptoK(queue,3);
    }
    
}
