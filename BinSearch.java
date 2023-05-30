import java.util.*;

class BinSearch
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter size of array");
        int arrn=sc.nextInt();
        int arr[]=new int[arrn];
        for (int i=0;i<arrn;i++)
        {
            System.out.println("Enter element of arr["+i+"]");
            arr[i]=sc.nextInt();
        }
        System.out.println("Enter key");
        int key=sc.nextInt();
        long starttime=System.nanoTime();
        int index=BSearch(arr, arrn, key);
        if (index!=-1)
        {
            System.out.println("Element found at index "+index);
        }
        else
        {
            System.out.println("Element not found");
        }
        long endtime=System.nanoTime();
        long timetaken=endtime-starttime;
        System.out.println("Time taken= "+timetaken+"ns");
    }
    public static int BSearch(int arr[], int n, int key)
    {
        int start=0;
        int last=arr.length;
        while (start<=last)
        {
            int mid=(start+last)/2;
            if (arr[mid]==key)
            {
                return mid;
                //System.out.println("Element found at"+mid);
            }
            else if (key<arr[mid])
            {
                last=mid-1;
            }
            else{
                start=mid+1;
            }
        }
        return -1;
    }
}