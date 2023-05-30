import java.util.*;
public class RMinMax {
     public static int findMinRec(int arr[], int n)
   {
     if(n == 1)
       return arr[0];
     else
       return Math.min(arr[n-1], findMinRec(arr, n-1));
   }
   public static int findMaxRec(int arr[], int n)
   {
     if(n == 1)
       return arr[0];
     else
       return Math.max(arr[n-1], findMaxRec(arr, n-1));
   }
   public static void main(String[] args)
   {
       Scanner sc=new Scanner(System.in);
       System.out.println("Enter the size of array: ");
       int N=sc.nextInt();
       int arr[]=new int[N];
       for(int i=0; i<N; i++)
       {
        System.out.println("Enter number");
        arr[i]=sc.nextInt();
       }
       System.out.println("Elements of the array are");
       for (int k = 0; k < N; k++) {
           System.out.print(arr[k] + " ");
       }
       System.out.println("\n");
       long start = System.nanoTime();
       int min=findMinRec(arr, N);
       int max=findMaxRec(arr, N);
       System.out.println("The min is: "+min+" and the max is: "+max);
       long end = System.nanoTime();
       long execution = end - start;
       System.out.println("Execution time: " + execution + " nanoseconds");
   }
}
