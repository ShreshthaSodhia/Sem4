import java.util.*;

public class KPGM
{
    static Scanner sc = new Scanner(System.in);
    public static void main(String args[])
    {
        System.out.print("Enter size of Knapsack = ");
        float knap_sz = sc.nextFloat();

        System.out.print("Enter no. of Items = ");
        int no_item = sc.nextInt();
        Item arr[] = new Item[no_item];

        System.out.println("Enter details of Items: ");
        for(int i=0;i<no_item;i++)
        {
            System.out.println("Enter weight");
            float wei = sc.nextFloat();
            System.out.println("Enter profit");
            float prof = sc.nextFloat();
            arr[i] = new Item(wei, prof);
        }
        System.out.println("\n\nCase I(Max Profit):");
        long start = System.currentTimeMillis();
        sort_by_pf(arr);
        max_prof(arr, knap_sz);
        long end = System.currentTimeMillis();
        System.out.println("Time Taken is: "+(end-start)+"ms");

        System.out.println("\n\nCase II(Min Weight):");
        long start1 = System.currentTimeMillis();
        sort_by_wt(arr);
        max_prof(arr, knap_sz);
        long end1 = System.currentTimeMillis();
        System.out.println("Time Taken is: "+(end1-start1)+"ms");

        System.out.println("\n\nCase III(Optimal):");
        long start2 = System.currentTimeMillis();
        sort_by_pf_wt(arr);
        max_prof(arr, knap_sz);
        long end2 = System.currentTimeMillis();
        System.out.println("Time Taken is: "+(end2-start2)+"ms");
    }
    // Sort By Profit in Descending Order
    static void sort_by_pf(Item arr[])
    {
        for(int i=0;i<arr.length-1; i++)
        {
            for(int j=0; j<arr.length-i-1;j++)
            {
                if(arr[j].pf < arr[j+1].pf)
                {
                    Item temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }
    // Sort By Weight in Ascending Order
    static void sort_by_wt(Item arr[])
    {
        for(int i=0;i<arr.length-1; i++)
        {
            for(int j=0; j<arr.length-i-1;j++)
            {
                if(arr[j].wt > arr[j+1].wt)
                {
                    Item temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }
    // Sort By Profit By Wt in Descending Order
    static void sort_by_pf_wt(Item arr[])
    {
        for(int i=0;i<arr.length-1; i++)
        {
            for(int j=0; j<arr.length-i-1;j++)
            {
                if(arr[j].pw < arr[j+1].pw)
                {
                    Item temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }
   
    static void max_prof(Item arr[], float max_sz)
    {
        fresh(arr);
        float curr_sz = 0, mx_prof = 0;
        int i = 0;
        while(i<arr.length && curr_sz < max_sz)
        {
            float rem_sp = max_sz-curr_sz;
            if(arr[i].wt <= rem_sp)
            {
                arr[i].wei_cons = 1;
                curr_sz += arr[i].wt;
                mx_prof += arr[i].pf;
            }
            else if(arr[i].wt > rem_sp)
            {
                float sz_cons = rem_sp/arr[i].wt;
                arr[i].wei_cons = sz_cons;
                curr_sz = max_sz;
                mx_prof += (arr[i].pf*sz_cons);
            }
            i++;
        }
        System.out.println("Max Profit = "+ mx_prof);
        String s = "", w = "";
        for(i=0;i<arr.length;i++)
        {
            s += (arr[i].wei_cons+ " ");
            w += (arr[i].wt+ " ");
        }
        System.out.println("      Weights     = { "+ w +"}");
        System.out.println("     Solution     = { "+ s +"} \n");
    }

    static void fresh(Item arr[])
    {
        for(int i = 0;i<arr.length;i++)
            arr[i].wei_cons = 0;
    }
}
class Item
{
    float wt, pf, pw, wei_cons;
    Item(float wt, float pf)
    {
        this.wt = wt;
        this.pf = pf;
        pw = pf/wt;
    }
}