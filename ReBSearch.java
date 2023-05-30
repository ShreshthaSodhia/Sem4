import java.util.*;
class ReBSearch
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
        int start=0;
        int last=arr.length;

        int index=RecBinSearch(arr, start, last, key);
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

    public static int RecBinSearch(int arr[],int start, int last, int key)
    {
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
            RecBinSearch(arr, start, mid-1,key);
        }
        else{
            RecBinSearch(arr, mid+1, last, key);
        }
    }
    return -1;
    }
}