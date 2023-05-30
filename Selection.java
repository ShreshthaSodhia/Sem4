import java.util.*;

class Insertion{
    public static void main(String args[])
    {
        int temp;
        System.out.println("Sorted Array=");
        int myarr[]=new int[]{34,67,53,12,5};
        for(int i=0;i<myarr.length;i++){
            int minindex=i;
            for(int j=i+1;j<myarr.length;j++)
            {
                if (myarr[j]<myarr[minindex])
                {
                    minindex=j;
                }
            }
            //swap smallest and myarr[i]
            temp=myarr[i];
            myarr[i]=myarr[minindex];
            myarr[minindex]=temp;
            System.out.println("Pass"+i);
            for(int k=0;k<5;k++){
            System.out.println(myarr[k]);}
        }
    }
}