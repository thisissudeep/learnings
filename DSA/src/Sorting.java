import java.util.ArrayList;

public class Sorting
{
    public void bubbleSort(int[] nums)   //iterate the bubble until sorting(move large to last)
    {
        int end=nums.length-1;
        boolean isSwap;
        while(end!=0)
        {
            isSwap=false;
            int i=0;
            int j=1;
            while(j<=end)
            {
                if(nums[i]>nums[j])   // if( names[i].compareTo(names[j]) >0 )
                {
                    int temp=nums[i];
                    nums[i]=nums[j];
                    nums[j]=temp;
                    isSwap=true;
                }
                i++; j++;
            }
            if(isSwap==false) break; //Pre exit condition if arr is already swapped
            end--;
        }
    }

    public void selectionSort(int[] nums)
    {
        int end=nums.length-1;
        while(end!=0)
        {
            int select=0;
            int pointer=1;
            while(pointer<=end)
            {
                if(nums[select]<nums[pointer])
                {
                    select=pointer;
                }
                pointer++;
            }
            int temp=nums[select];
            nums[select]=nums[end];
            nums[end]=temp;
            end--;
        }
    }

    public int[] mergeSort(int low,int high,int[] nums)
    {
        if(low==high) 
        {
            // int []arr=new int[1];
            // arr[0]=nums[low];
            // return arr;
            return new int[]{nums[low]};
        }
        
        int mid=(low+high)/2;
        int []nums1=mergeSort(low,mid,nums);
        int []nums2=mergeSort(mid+1,high,nums);
        return mergeTwoSortedArr(nums1,nums2);
    }
    public int[] mergeTwoSortedArr(int[] nums1,int[] nums2)
    {
        int p1=0;
        int p2=0;
        int i=0;
        int size1=nums1.length;
        int size2=nums2.length;
        int[] ans=new int[size1+size2];
        
        while(p1<size1 && p2<size2)
        {
            if(nums1[p1]<nums2[p2])
            {
                ans[i]=nums1[p1];
                i++;
                p1++;
            }
            else{
                ans[i]=nums2[p2];
                i++;
                p2++;
            }
        }
        if(p1==size1)
        {
            while(p2<size2)
            {
            ans[i]=nums2[p2];
            p2++;
            i++;
            }
        }
        else
        {
            while(p1<size1)
            {
            ans[i]=nums1[p1];
            i++;
            p1++;
            }
        }
        return ans;
    }

    //Function to merge k sorted arrays.
    public static ArrayList<Integer> mergeKArrays(int[][] arr,int k) 
    {
        ArrayList<Integer> list=new ArrayList<>();
        int[] indices=new int[k];
        int index=0;
        int totElements=k*k;

        while(index<totElements)
        {

            int smallArrI=-1;
            int smallElement=Integer.MAX_VALUE;
            for(int i=0;i<k;i++)
            {
                if(indices[i]<k)
                {
                  int curMatEle=arr[i][indices[i]];
                  if(curMatEle<smallElement)
                   {
                    smallElement=curMatEle;
                    smallArrI=i;
                   }
                } 
            }
            list.add(smallElement);
            indices[smallArrI]++;
            index++;
        }
        return list;
    }
    
}

class Main_Sorting
{
    public static void main(String [] args)
    {
        Sorting st=new Sorting();
        
        int[] nums={10,40,70,20,80,5};
        
        // st.bubbleSort(nums);
        // st.selectionSort(nums);
        // for(int num:nums) System.out.print(num+" ");
        
        // int[] ans=st.mergeSort(0,nums.length-1,nums);
        // int[] ans=st.mergeTwoSortedArr(new int[]{10,40,50,80,90,100},new int[]{20,30,40});
        // for(int num:ans) System.out.print(num+" ");
    }
}
