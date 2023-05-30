import java.util.*;

class InsertionSort {
    public static void main(String args[]) {
        int myarr[] = new int[] {34, 67, 53, 12, 5};
        for (int k = 1; k < myarr.length; k++) {
            int temp = myarr[k];
            int j = k - 1;
            while (j >= 0 && temp < myarr[j]) {
                myarr[j + 1] = myarr[j];
                j = j - 1;
            }
            myarr[j + 1] = temp;
        
            System.out.println("Pass " + k);
            System.out.println("k = " + k);
            System.out.println("temp = " + temp);
            System.out.println("j = " + j);
            System.out.println("Sorted Array at this stage:");
            for (int i = 0; i < myarr.length; i++) {
                System.out.println(myarr[i]);
            }
        }
    }
}
