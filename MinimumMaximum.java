import java.util.*;
class MinimumMaximum
{
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
        int min=Minimum(myarr, arrn);
        int max=Maximum(myarr, arrn);
        System.out.println("min="+min);
        System.out.println("max="+max);
        long endtime=System.nanoTime();
        long timetaken=endtime-starttime;
        System.out.println("Time taken= "+timetaken+"ns");
    }
    public static int Minimum(int arr[], int arrlen)
    {
        int min=arr[0];
        for(int i=0; i<arrlen;i++)
        {
            if (arr[i]<min)
            {
                min=arr[i];
            }
        }
        return min;
    }
    public static int Maximum(int arr[], int arrlen)
    {
        int max=arr[arrlen-1];
        for(int i=arrlen-1;i>=0;i--)
        {
            if (arr[i]>max)
            {
                max=arr[i];
            }
        }
        return max;
    }
}