import java.util.*;
class DCMinimumMaximum
{
    static class MMPair
    {
        int min;
        int max;
    }
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter size of array");
        int arrn=sc.nextInt();
        int myarr[]=new int[arrn];
        for (int i=0;i<arrn;i++)
        {
            System.out.println("Enter element of arr["+i+"]");
            myarr[i]=sc.nextInt();
        }
        long starttime=System.nanoTime();
        MMPair minmaxfinal= MM(myarr,0,arrn-1);
        System.out.println("Min= "+minmaxfinal.min);
        System.out.println("Max= "+minmaxfinal.max);
        long endtime=System.nanoTime();
        long timetaken=endtime-starttime;
        System.out.println("Time taken= "+timetaken+"ns");
    }
    public static MMPair MM(int arr[], int low, int high)
    {
        MMPair minmax=new MMPair();
        MMPair MML=new MMPair();
        MMPair MMR=new MMPair();
        int mid;
        //only one element
        if (low==high)
        {
            minmax.min=arr[low];
            minmax.max=arr[low];
            return minmax;
        }
        //2 elements 
        if (high==low+1)
        {
            if (arr[low]>arr[high])
            {
                minmax.max=arr[low];
                minmax.min=arr[high];
            }
            else
            {
                minmax.min=arr[low];
                minmax.max=arr[high];
            }
            return minmax;
        }
        //MORE THAN 2
        mid=(low+high)/2;
        MML=MM(arr, low, mid);
        MMR=MM(arr, mid+1, high);
        //compare mins of both mml and mmr
        if (MML.min < MMR.min) {
            minmax.min = MML.min;
        }
        else {
            minmax.min = MMR.min;
        }
        // compare maxes or both mml and mmr
        if (MML.max > MMR.max) {
            minmax.max = MML.max;
        }
        else 
        {
            minmax.max = MMR.max;
        }
        return minmax;
    }
}



