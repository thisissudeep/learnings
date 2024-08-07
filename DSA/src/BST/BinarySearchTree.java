package BST;

import javax.swing.tree.TreeNode;

class Main {
    
    public static void main(String[] args)
    {
    BinarySearchTree bst=new BinarySearchTree();  //BinarySearchTree is a datastructure we created (Scanner sc=new Scanner(System.in) using class which has many functions to get.
    int[] nums={10,20,30,40,50,60,70};
    Node bstNode=bst.buildBST(0,6,nums); //Node is a custom datatype we created (int i=1;) using class,which  doesnot has any functions, here no objects needed to be created.
    System.out.println(bst.isValidBST());


    }
}

class Node
{
    int data;
    Node left;
    Node right;
    public Node(int data)
    {
        this.data=data;
        this.left=null;
        this.right=null;
    }
} 

public class BinarySearchTree
{
    Node root;
    public Node buildBST(int start,int end,int[] arr)
    {
        if(start>end) return null;
        
        int mid=(start+end)/2;
        System.out.print(arr[mid]+" ");
        Node rootNode=new Node(arr[mid]);
        
        rootNode.left=buildBST(start,mid-1,arr);
        rootNode.right=buildBST(mid+1,end,arr);
        
        root=rootNode;
        return rootNode;
    }

    boolean bool;
    public boolean isValidBST() {          // Inorder Traversal
        if(root.left==null && root.right==null) return true;
         bool=true;
         isBST(root);
         return bool;
     }
    long lastLarge=Long.MIN_VALUE;
    void isBST(Node root) {
        if(root==null) return;
        
        if(bool) isBST(root.left);
        
        if(lastLarge<root.data) lastLarge=root.data;
        else bool=false;
        
        if(bool) isBST(root.right);
    }
    
    int count;
    int kthValue;
    public int kthSmallest(Node root, int k) {
        count=0;
        kthValue=0;
        inOrderTraversal(root,k);
        return kthValue;
    }
    private void inOrderTraversal(Node root,int k)
  {
    if(root==null) return;
    if( kthValue==0) inOrderTraversal(root.left,k);
    count++; if(count==k) kthValue=root.data;
    if( kthValue==0) inOrderTraversal(root.right,k);
  }
}