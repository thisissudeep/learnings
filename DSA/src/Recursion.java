import java.util.Scanner;

public class Recursion {

    static Scanner sc=new Scanner(System.in);
    public static void getArray(int[] arr,int n)
    {
        if(n==0)
        {
            arr[n]=sc.nextInt();
            return;
        }
        getArray(arr,n-1);
        arr[n]=sc.nextInt();
    }

    public static void displayAscending(int [] arr,int n)
    {
        if(n==0)
        {
            System.out.print(arr[n]+" ");
            return;
        }
        displayAscending(arr,n-1);
        System.out.print(arr[n]+" ");
    }

    public static void displayDescending(int[] arr,int n)
    {
        if(n==0)
        {
            System.out.print(arr[n]);
            return;
        }
        System.out.print(arr[n]+" ");
        displayDescending(arr,n-1);
    }

    private static int max=Integer.MIN_VALUE;
    public static int findMax (int[] arr,int n)
    {
        if(n==-1) return max;
        if(arr[n]>max) max=arr[n];
        return findMax(arr,n-1);
    }

    public static void toWords(int num)
    {
        if(num==0) return;
        String[] words={"zero","one","two","three","four","five","six","seven","eight","nine"};
        toWords(num/10);
        System.out.print(words[num%10]+" ");
    }

    public static void findTarget(int[] arr,int index,int target)
    {
        if(index==arr.length) return;
        if(arr[index]==target)
        {
            System.out.println(index);
        }
        findTarget(arr,index+1,target);
    }


    private static int fact=1;
    public static void recursion(int n)
    {
        if(n==1)
        {
            fact*=n;
            System.out.println(fact);
            return;
        }
        fact*=n;
        recursion(n-1);

    }


    private static StringBuffer result=new StringBuffer();
    private static boolean[] freq=new boolean[26];
    public static void removeDup(String str,int index)
    {
        if(index==str.length())
        {System.out.print(result);return;}

        char ch=str.charAt(index);
        if(freq[ch-'a']!=true)

        {
            freq[ ch -'a']=true;
            result.append(ch);
        }
        removeDup(str,index+1);
    }


    public static boolean checkSorted(int[]arr , int index)
    {
        if(index==arr.length-1) return true;
        if(arr[index]<arr[index+1]) return checkSorted(arr,index+1);
        else return false;
    }
    

    public void printSubSequence(String string,String ans){
        if(string.isEmpty()){
            System.out.println(ans);
            return;
        }
        char ch=string.charAt(0);
        printSubSequence(string.substring(1),ans+ch);
        printSubSequence(string.substring(1),ans);
    }
    

    public void findTotal(String result, int count, int total) {
        if (count == total) {
            System.out.println(result);
            return;
        }
        if (count > total) return;

        findTotal(result+1, count + 1, total);
        findTotal(result+2, count + 2, total);
        findTotal(result+5, count + 5, total);
    }

    public void findWays(int n, int row, int col, String path) {
        if (row == n && col == n) {
            System.out.println(path);
            return;
        }
        if (row > n || col > n) return;
        findWays(n, row, col + 1, path + "H");
        findWays(n, row + 1, col, path + "V");
    }
    
    public void generateParenthesis(int n, int openLength,int closeLength ,String result){
        if(openLength==n && closeLength==n){
            System.out.println(result);
            return;
        }
        if (closeLength>n || openLength >n) return;
        generateParenthesis(n,openLength+1,closeLength,result+'(');
        if(closeLength<openLength) generateParenthesis(n,openLength,closeLength+1,result+')');
    }
    



    public int binarySearch(int[] nums, int target) {
        return doBinarySearch(nums,target,0,nums.length-1);
    }
    private int doBinarySearch(int[] nums,int target,int low,int high)
    {
        if(low>high) return -1;  //Neagtive Base Condition

        int mid=(low+high)/2;
        if(target==nums[mid]) return mid;  // Positive Base Condition
        else if(target>nums[mid])  return doBinarySearch(nums,target,mid+1,high);
        else return doBinarySearch(nums,target,low,mid-1);
        
    }

    
    public int linearSearch(int[] nums,int target)
    {
        return doLinearSearch(nums,target,0,nums.length);
    }
    private int doLinearSearch(int[] nums,int target,int index,int n)
    {
        if(index==n) return -1;
        if(nums[index]==target) return index;
        return doLinearSearch(nums,target,index+1,n);
    }


    public int findLastPosition(int[] nums,int target,int index)
    {
        if(index==-1) return -1;
        if(nums[index]==target) return index;
        return findLastPosition(nums,target,index-1);
    }

}


class recursion_operations{
    public static void main(String[] args)
    {
        Recursion rc=new Recursion();

        int[] nums={0,24,7,3,10,15,15,15,22};
        System.out.println();

        // rc.printSubSequence("abc","");
        // rc.findTotal("", 0, 10);
        // rc.findWays(2,0,0,"");
        // rc.generateParenthesis(4,0,0,"");

        // System.out.println("Binary Search: "+new Recursion().binarySearch(nums,0));
        
        // System.out.println("Linear Search: "+rc.linearSearch(nums,22));

        // System.out.println("First Occurence: "+rc.linearSearch(nums,15));
        // System.out.println("Last Occurence: "+rc.findLastPosition(nums,15,nums.length-1));

        
        for(int num:nums) System.out.println(num);
    }
}

