import java.util.*;
//EXP1 WHOLE
class MainSort
{
    void ItInsertionSort(int arr[])
    {
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key)
            {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }

    void ReInsertionSort(int arr[], int n)
    {
        // Base case
        if (n <= 1)
            return;
        // Sort first n-1 elements
        ReInsertionSort(arr, n-1);      
        // Insert last element at its correct position in sorted array.
        int last = arr[n-1];
        int j = n-2;
       
        /* Move elements of arr[0..i-1], that are greater than key, to one position ahead of their current position */
        while (j >= 0 && arr[j] > last)
        {
            arr[j+1] = arr[j];
            j--;
        }
        arr[j+1] = last;

    }
       
    void ItSelectionSort(int arr[])
    {
        int n=arr.length;
        for(int i=0; i<arr.length-1; i++)
        {
            int pos = smallestPosFrom(i,arr);
            swap(arr,i,pos);
        }

    }
    private static void swap(int[] arr,int pos1, int pos2)
    {
        int temp;
        temp = arr[pos1];
        arr[pos1] = arr[pos2];
        arr[pos2] = temp;
    }
    private static int smallestPosFrom(int from,int[] arr)
    {
        int pos=from;
        for(int i=from+1; i<arr.length; i++)
        if(arr[i]<arr[pos])
            pos=i;
        return pos;
    }

        // Return minimum index
    static int minIndex(int a[], int i, int j)
    {
        if (i == j)
            return i;
      
        // Find minimum of remaining elements
        int k = minIndex(a, i + 1, j);
      
        // Return minimum of current and remaining.
        return (a[i] < a[k])? i : k;
    }
      
    // Recursive selection sort. n is size of a[] and index
    // is index of starting element.
    void ReSelectionSort(int a[], int n, int index)
    {
    {
        // Return when starting and size are same
        if (index == n)
           return;
      
        // calling minimum index function for minimum index
        int k = minIndex(a, index, n-1);
      
        // Swapping when index and minimum index are not same
        if (k != index){
           // swap
           int temp = a[k];
           a[k] = a[index];
           a[index] = temp;
        }
        // Recursively calling selection sort function
        ReSelectionSort(a, n, index + 1);
    }
    }

    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        Random rn=new Random();
        System.out.println("Enter number of elements of array");
        int an=sc.nextInt();
        int arr[]=new int[an];
        System.out.println("Enter range of numbers");
        int ranrange=sc.nextInt();
        for (int i=0;i<an;i++)
        {
            arr[i]=rn.nextInt(ranrange);
        }

        /*         for(int i=0;i<an;i++)
        {
            System.out.println("Enter arr["+i+"]");
            arr[i]=sc.nextInt();
        }*/

        int n=arr.length;
        //int arr[] = { 5, 1, 4, 2, 8 };
       
        boolean input=true;
        do
        {
            System.out.println("Enter which sort to use:\n1.Iterative Insertion Sort \n2.Recursive Insertion Sort \n3.Iterative Selection Sort \n.4 Recursive Selection Sort \n5.Exit");
            int choice=sc.nextInt();
            MainSort ob = new MainSort();
            switch(choice)
            {
            case 1:
            long start=System.nanoTime();
            ob.ItInsertionSort(arr);
            System.out.println("Sorted Array:");
            for(int i=0;i<arr.length;i++)
            {
                System.out.print(arr[i]+"\t");
            }
            long end=System.nanoTime();
            System.out.println("\nTime taken= "+(end-start)+"ns");
            break;
            case 2:
            long start2=System.nanoTime();
            ob.ReInsertionSort(arr,n);
            System.out.println("Sorted Array:");
            for(int i=0;i<arr.length;i++)
            {
                System.out.print(arr[i]+"\t");
            }
            long end2=System.nanoTime();
            System.out.println("\nTime taken= "+(end2-start2)+"ns");
            break;
            case 3:
            long start3=System.nanoTime();
            ob.ItSelectionSort(arr);
            System.out.println("Sorted Array:");
            for(int i=0;i<arr.length;i++)
            {
                System.out.print(arr[i]+"\t");
            }
            long end3=System.nanoTime();
            System.out.println("\nTime taken= "+(end3-start3)+"ns");
            break;
            case 4:
            long start4=System.nanoTime();
            ob.ReSelectionSort(arr,arr.length,0);
            System.out.println("Sorted Array:");
            for(int i=0;i<arr.length;i++)
            {
                System.out.print(arr[i]+"\t");
            }
            long end4=System.nanoTime();
            System.out.println("\nTime taken= "+(end4-start4)+"ns");
            break;
            case 5:
            input=false;
            break;
            default:
            System.out.println("Enter valid input");
            input=true;
            }
        }while(input==true);
        sc.close();
    }
}
