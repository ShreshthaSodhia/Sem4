import java.util.Scanner;
class BinarySearch {
int binarySearch(int arr[], int x)
{
int l = 0, r = arr.length - 1;
while (l <= r) {
int m = l + (r - l) / 2;

if (arr[m] == x)
return m;

if (arr[m] < x)
l = m + 1;

else
r = m - 1;
}

return -1;
}
public static void main(String args[]){
    BinarySearch ob = new BinarySearch();
Scanner sc=new Scanner(System.in);
System.out.println("Enter the number of elements: ");
int n=sc.nextInt();
int[] arr=new int[n];
for(int i=0;i<n;i++){
System.out.println("Enter the elements: ");
int num=sc.nextInt();
arr[i]=num;
}
System.out.println("Enter the element to be searched: ");
int x=sc.nextInt();
int result = ob.binarySearch(arr, x);
if (result == -1)
System.out.println("Element not present");
else
System.out.println("Element found at index " + result);
int max_element = arr[0], min_element = arr[0];
for (int j = 0; j < n; j++) {
if (arr[j] > max_element) {
max_element = arr[j];
}
if (arr[j] < min_element) {
min_element = arr[j];
}
}

System.out.println("\n Maximum Number: " + max_element);
System.out.println("\n Minimum Number: " + min_element);
}
}import java.util.*;
class quicksort
{
static Scanner sc = new Scanner(System.in);
static void disp(int a[])
{
System.out.println();
for(int i=0;i<a.length;i++)
System.out.print(a[i]+" ");
}
static void quick(int arr[], int lw, int hg)
{
    if(lw < hg)
{
int pivot_ind = partition(arr,lw,hg+1);
quick(arr,lw,pivot_ind-1);
quick(arr,pivot_ind+1,hg);
}
}
static int partition(int arr[], int lw, int hg)
{
int v = arr[lw] , i = lw, j = hg;
while(i < j)
{
do
{
i++;
}while(i < hg && arr[i] <= v);
do
{
j--;
}while(j > lw && arr[j] >= v);
if(i<j)
interchange(arr,i,j);
}
arr[lw] = arr[j];
arr[j] = v;
System.out.print("Pass = ");
disp(arr);
System.out.println();
return j;
}
static void interchange(int arr[], int i, int j)
{
int temp = arr[i];
arr[i] = arr[j];
arr[j] = temp;
}
public static void main(String args[])
{
System.out.println("Enter Range of Array: ");
int usr_inp = sc.nextInt();
Random rn = new Random();
int usr_arr[] = new int[usr_inp];
for(int i=0;i<usr_inp;i++){
    for(int i=0;i&lt;N;i++)
        {
            double x=Math.random()*300;
            int num= (int)x;
            arr[i]= num;
        }
        System.out.println("Random array:");
        printArray(arr,N);
       
        long start = System.nanoTime();
        quickSort(arr, 0, N - 1);
        System.out.println("\nSorted array: ");
        printArray(arr, N);
        long end = System.nanoTime();
        long execution = end - start;
        System.out.println("\nExecution time: " + execution + " nanoseconds");
}
}
}
