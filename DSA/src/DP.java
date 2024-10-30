public class DP
{
    public int findNthFibonacci(int nth)
    {
        int[] memory=new int[nth+1];
        memory[1]=1;
        memory[2]=1;
        return findNthFibonacci(nth,memory);
    }
    private int findNthFibonacci(int nth,int[] mem)
    {
       if(mem[nth]!=0) return mem[nth]; 
       mem[nth-1] =findNthFibonacci(nth-1,mem);
       mem[nth-2] =findNthFibonacci(nth-2,mem);
       return mem[nth-1]+mem[nth-2];
    }

    
    public int uniquePaths(int m, int n) {
        int[][] mem=new int[m][n];
        return uniquePaths(0,0,m,n,mem);
    }
    private int uniquePaths(int i,int j,int m,int n,int[][]mem)
    {
        if(i==m || j==n) return 0;              //Negative BaseCase
        if(mem[i][j]!=0) return mem[i][j];      //Memorization
        if(i==m-1 && j==n-1) return 1;          //Positive BaseCase
        int Hways=uniquePaths(i,j+1,m,n,mem);   //Multiple Recursion
        int Vways=uniquePaths(i+1,j,m,n,mem);
        mem[i][j]=Hways+Vways;
        return Hways+Vways;
    }

    public int climbStairs(int n) {
        int[] mem=new int[n+1];
        return climbStairs(0,n,mem);
    }
    private int climbStairs(int st,int n,int[] mem)
    {
        if(st>n) return 0;
        if(mem[st]!=0) return mem[st];
        
        if(st==n) return 1;
        int OstWays=climbStairs(st+1,n,mem);
        int TstWays=climbStairs(st+2,n,mem);
        mem[st]=OstWays+TstWays;
        return mem[st];
    }

}

class Main
{
    public static void main(String[] args)
    {
        System.out.println();
        DP dp=new DP();

        // System.out.print(dp.findNthFibonacci(45));
        // System.out.println(dp.uniquePaths(20,20));
        // System.out.println(dp.climbStairs(2));
    }
}