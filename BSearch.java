import java.util.*; 
public class BSearch
{ 
 
 public static void main(String args[]) 
 { 
 //Scanner sc=new Scanner(System.in);
 System.out.println("Size,Recursive,Iterative"); 
 for(int i=10;i<=10000;i=i+10)
 { 
 int arr[]=new int[i]; 
 for(int a=0;a<i;a++) 
 arr[a]=a+1; 
 int key =arr[i-1]; 
 //System.out.println("Enter size of array");
 //int n=sc.nextInt();
 //for(int i=0;i<n;i++)
 //{
    //System.out.println("Enter arr["+i+"]");
    //arr[i]=sc.nextInt();
 //}
 //System.out.println("Enter key");
 //int key=sc.nextInt(); 
 BSearch ob = new BSearch(); 
 long start,end,diff1,diff2,start2,end2; 
 start=System.nanoTime(); 
 int result = ob.RecursivebinarySearch(arr, 0, i - 1, key,0); 
 
 end=System.nanoTime(); 
 diff1=end-start;  
 start2=System.nanoTime(); 
 int result2 = ob.IterativebinarySearch(arr,key); 
 end2=System.nanoTime(); 
 diff2=end2-start2; 

 System.out.println(i+",\t"+result+"ns, \t"+result2+"ns");  
 } 
 } 
 
 int RecursivebinarySearch(int arr[], int l, int r, int x,int rec_n) 
 { 
 ++rec_n; 
 if (r >= l) { 
 int mid = l + (r - l) / 2; 
 
 // If the element is present at the 
 // middle itself 
 if (arr[mid] == x) 
 return rec_n; 
 
 // If element is smaller than mid, then 
 // it can only be present in left subarray 
 if (arr[mid] > x) 
 return RecursivebinarySearch(arr, l, mid - 1, x,rec_n); 
 
 // Else the element can only be present 
 // in right subarray 
 return RecursivebinarySearch(arr, mid + 1, r, x,rec_n); 
 } 
 
 return rec_n; 
 } 
 
 
 int IterativebinarySearch(int arr[], int x) 
 { 
 int iter=0; 
 int l = 0, r = arr.length - 1; 
 while (l <= r) { 
 ++iter; 
 int m = l + (r - l) / 2; 
 
 // Check if x is present at mid 
 if (arr[m] == x) 
 return m; 
 
 // If x greater, ignore left half 
 if (arr[m] < x) 
 l = m + 1; 
  // If x is smaller, ignore right half 
  else 
  r = m - 1; 
  } 
  
  // if we reach here, then element was 
  // not present 
  return iter; 
  } 
 }