import java.util.*;
public class IMinMax {
   static int[] sort(int arr[], int n)
   {
       int i, key, j;
       for(i=1; i<n; i++)
       {
           key=arr[i];
           j=i-1;
           while (j >= 0 && arr[j] > key)
           {
               arr[j + 1] = arr[j];
               j = j - 1;
           }
           arr[j + 1] = key;
       }
       for (int k = 0; k < n; k++) {
           System.out.print(arr[k] + " ");
       }
       System.out.println("\n");
       return arr;
   }
   public static void main(String[] args){
       Scanner sc=new Scanner(System.in);
       System.out.println("Enter the size of array: ");
       int N=sc.nextInt();
       int arr[];
       arr=new int[N];
       for(int i=0; i<N; i++)
       {
           System.out.println("Enter number");
           arr[i]=sc.nextInt();
       }
       System.out.println("\nSorted Array is");
       int array[]=sort(arr,N);  
       System.out.println("Min element is: "+array[0]+"\n");
       System.out.println("Max element is: "+array[N-1]);
   }
}
