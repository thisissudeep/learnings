package BT;
import java.util.Queue;

import javax.swing.tree.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

class Node{
    int data;
    Node left;
    Node right;

     Node(){}

     Node(int data){this.data=data;}

     Node(int data,Node left,Node right)
    {
        this.data=data;
        this.left=left;      
        this.right=right;
    }


}

public class BinaryTree {
      
    Node root;


    // To build tree using array and return root of it
    int index=-1;
    public Node buildTree(int[] nums)
    {
        // Node newNode=new Node();  need to be given if we Node class is not static
        index++;
        if(nums[index]==-1) return null;
        Node newNode =new Node(nums[index]);
        newNode.left =buildTree(nums);
        newNode.right =buildTree(nums);
        root=newNode;
        return newNode;
    }


    // Depth First Search (DFS)
    public void doPreOrderTraversal(Node root) {
    if (root == null) return;
    System.out.print(root.data + " ");
    doPreOrderTraversal(root.left);
    doPreOrderTraversal(root.right);
    }

    public void doInOrderTraversal(Node root) {
    if (root == null) return;
    doInOrderTraversal(root.left);
    System.out.print(root.data + " ");
    doInOrderTraversal(root.right);
    }

    public void doPostOrderTraversal(Node root) {
    if (root == null) return;
    doPostOrderTraversal(root.left);
    doPostOrderTraversal(root.right);
    System.out.print(root.data + " ");
    }


    
    public void levelOrder()  //Breadth First Search (BFS)
    {
        doLevelOrder(root);
    }

    public void doLevelOrder(Node root)
    {
        if(root==null) return;
        Queue<Node> queue =new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty())
        {
        Node curr=queue.peek();
        if(curr.left!=null) queue.add(curr.left);
        if(curr.right!=null) queue.add(curr.right);
        System.out.print(curr.data+" ");
        queue.remove();
        }
    }

    public void zigZagLevelOrder()
    {
        List<Queue<Node>> levels = doZigZagLevelOrder(root);
        boolean reverse=false;
        for(Queue<Node> level:levels)
        {                     
            if(reverse) reverseQueue(level);  //can be used as levelorder without reversing
            for(Node node:level)
            {
                System.out.print(node.data+" ");
            }
            System.out.println();
            reverse=!reverse;
        }
    }

    public List<Queue<Node>> doZigZagLevelOrder(Node root)
    {
        List<Queue<Node>> levels=new ArrayList<>();
        if(root==null) return levels;
        Queue<Node> level=new LinkedList<>();
        level.add(root);
        while(!level.isEmpty())
        {   
            levels.add(new LinkedList<>(level));
            
            int n=level.size();
            for(int i=0;i<n;i++)
            {
                Node curr=level.remove();
                if(curr.left!=null) level.add(curr.left);
                if(curr.right!=null) level.add(curr.right); 
            }
            
        }
        return levels;
    }

    public void reverseQueue(Queue<Node> queue)
    {
        if(queue.isEmpty()) return;
        Node node=queue.remove();
        reverseQueue(queue);
        queue.add(node);
    }
    

    public void bottomUpLevelOrder()
    {
      List<List<Integer>> levels=new ArrayList<>();
      Queue<Node> q=new LinkedList<>();
      q.add(root);
      while(!q.isEmpty())
      {
        List<Integer> level=new ArrayList<>();
		int n=q.size();
        for(int i=0;i<n;i++)
        {
          Node temp=q.poll();
          level.add(temp.data);
          if(temp.left!=null) q.add(temp.left);
          if(temp.right!=null) q.add(temp.right);
        }
        levels.add(level);
      }
      for(int i=levels.size()-1;i>=0;i--)
      {
        for(int j=0;j<levels.get(i).size();j++)   
        {
          System.out.print(levels.get(i).get(j)+" ");
        }
      }
    }

    public int fakeHeight(Node root)
    {
        List<Queue<Node>> levels= doZigZagLevelOrder(root);
        return levels.size();
    }

    int level;
    public int level()
    {
        level=0;
        findlevel(root,0);
        return level;
    }
    
    public void findlevel(Node root,int curr_height)
    {
        if(root==null) return;
        if(curr_height>level) level=curr_height;
        findlevel(root.left,curr_height++);
        findlevel(root.right,curr_height++);
    }

    public int height()
    {
        if(level==0) level();
        return level+1;
    }



    public int deepestLeavesSum(Node root)
    {
        if(root==null) return 0;
        Queue<Node> queue=new LinkedList<>();
        int deepLeavesSum=0;
        queue.add(root);
        while(!queue.isEmpty())
        {
            int currLeavesSum=0;
            int n=queue.size();
            for(int i=0;i<n;i++)
            {
                Node currNode=queue.remove();
                currLeavesSum+=currNode.data;
                if(currNode.left!=null) queue.add(currNode.left);
                if(currNode.right!=null) queue.add(currNode.right);
            }
            deepLeavesSum=currLeavesSum;
        }
        return deepLeavesSum;
    }


  int sumLeft;
  public int sumOfLeftLeaves(Node root)
  {
    sumLeft=0;
    sumOfLeftLeaves(root,false);
    return sumLeft;
  }
  public void sumOfLeftLeaves(Node root,boolean left)
  {
  	if(root==null) return;
    if(root.left==null && root.right==null && left==true)
    {
      sumLeft+=root.data;
      return;
    }
    if(root.left!=null) sumOfLeftLeaves(root.left,true);
    if(root.right!=null) sumOfLeftLeaves(root.right,false);
  }

  
    // To check whether the node is Symmetric(same in left & right)
    boolean symcheck;
    public boolean isSymmetric(Node root) {
        boolean symcheck=true;
        checkSymmetric(root.left,root.right);
        return symcheck;
    }

    private void checkSymmetric(Node root1,Node root2)
    {
        if(symcheck==false) return;  //Pre Exit Condition (to avoid unnecessary steps after finding it is not symmetric
        if(root1==null && root2==null) return;   //Negative Base Condition
        if (root1==null||root2==null)   //to change check ,if one node is null and other is val
        {
            symcheck=false;
            return;
        }
        if(root1.data!=root2.data) //to change check ,if both nodes are values
        {
            symcheck=false;
            return;
        }   
        checkSymmetric(root1.left,root2.right);
        checkSymmetric(root1.right,root2.left);
    }



    boolean idencheck;
    public boolean isSameTree(Node p, Node q) {
        boolean idencheck=true;
        checkIdentical(p,q);
        return idencheck;
    }

    public void checkIdentical(Node root1,Node root2)
    {
        if(idencheck==false) return; 
        if(root1==null && root2==null) return; 
        if (root1==null||root2==null)
        {
            idencheck=false;
            return;
        }
        if(root1.data!=root2.data)
        {
            idencheck=false;
            return;
        }   

        checkIdentical(root1.left,root2.left);
        checkIdentical(root1.right,root2.right);
    }
}


class Main {
    public static void main(String args[])
    {
        BinaryTree bt=new BinaryTree();

        //input elements acc. to preorder traversal
        int[] nums={1,2,4,8,-1,-1,9,-1,-1,5,10,-1,-1,11,-1,-1,3,6,12,-1,-1,13,-1,-1,7,14,-1,-1,15,-1,-1};
        Node root=bt.buildTree(nums);

        // Node root =new Node(1);
        // root.left=null;
        // root.right=new Node(2);
        // root.right.left=new Node(3);
        
        System.out.println();
        bt.doPreOrderTraversal(root);
        System.out.println();
        bt.doInOrderTraversal(root);
        System.out.println();
        //bt.levelOrder();
        //bt.zigZagLevelOrder();
        // System.out.println(bt.height());
        // System.out.println(bt.level());
        // System.out.println(bt.deepestLeavesSum(root));

    }
}



  
