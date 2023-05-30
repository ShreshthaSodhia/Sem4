/* MERGE SORT */

import java.util.*;
public class mergesort
{
    static Scanner sc = new Scanner(System.in);
    static void merge_sort(int arr[], int lw, int hg)
    {
        if(lw<hg)
        {
            int mid = (hg+lw)/2;
            merge_sort(arr,lw,mid);
            merge_sort(arr,mid+1,hg);
            merge_ele(arr,lw,mid,hg);
        }
    }

    static void disp(int a[])
    {
        System.out.println();
        for(int i=0;i<a.length;i++)
            System.out.print(a[i]+" ");
    }

    static void merge_ele(int arr[], int lw, int mid, int hg)
    {
        int sz1 = mid - lw + 1;
        int sz2 = hg - mid;

        int nw1[] = new int[sz1];
        int nw2[] = new int[sz2];
        for(int i=0;i<sz1;i++)
            nw1[i] = arr[i+lw];
        for(int i=0;i<sz2;i++)
            nw2[i] = arr[mid+1+i];
        int i=0,j=0;
        int ind = lw;
        while(i < sz1 && j < sz2)
        {
            if(nw1[i] >= nw2[j])
            {
                arr[ind] = nw2[j];
                j++;
                ind++;
            }
            else
            {
                arr[ind] = nw1[i];
                i++;
                ind++;
            }
        }
        while(i < sz1)
        {
            arr[ind] = nw1[i];
            i++;
            ind++;
        }
        while(j < sz2)
        {
            arr[ind] = nw2[j];
            j++;
            ind++;
        }
        System.out.print("Pass = ");
        disp(arr);
        System.out.println();
    }


    public static void main(String args[])
    {
        System.out.println("Enter length of array: ");
        int arrlen = sc.nextInt();
        System.out.println("Enter range");
        int ranrange=sc.nextInt();
        System.out.println();

        Random rn = new Random();
        int arr[] = new int[arrlen];

        for(int i=0;i<arrlen;i++)
        {
            System.out.println("Enter Element");
            //arr[i]=sc.nextInt();
            arr[i] = rn.nextInt(ranrange);
        }

        // System.out.println("\nArray = ");

        // for(int i=0;i<arrlen;i++)
        //     System.out.print(arr[i]+" ");

        System.out.println();

        long start_time = System.nanoTime();
        merge_sort(arr,0,arr.length-1);
        long end_time = System.nanoTime();
        System.out.println("\n\nSorted Array = ");
        disp(arr);
        System.out.println("\n\nExecution Time = "+ (end_time - start_time)+"ns");
    }
}