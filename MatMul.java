import java.util.*;
class MatMul{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter No.of Matrix = ");
        int mat = sc.nextInt(),i,j;
        int dim[] = new int[mat+1];
        int cost[][] = new int[mat+1][mat+1];
        int path[][] = new int[mat+1][mat+1];
        System.out.println("Enter Matrix Dimension(End with -1) =");
        dim[0] = sc.nextInt();
        for(i=1;i<dim.length;i++)
        {
            dim[i] = sc.nextInt();
            sc.nextInt();
        }
        for(i=0;i<cost.length;i++)
            for(j=0;j<cost.length;j++)
            {
                cost[i][j] = -1;
                path[i][j] = -1;
            }
       
        MCM(cost, path, dim);
        System.out.println("\nCost Array = ");
        display(cost);
        System.out.println("\nPath Array = ");
        display(path);
    }
    
    static void MCM(int cost[][], int path[][], int dim[])
    {
        for(int i=1;i<=cost.length;i++)
        {
            int k=1;
            for(int j=i;j<cost.length;j++)
            {
                if(k==j)
                {
                    cost[k][j] = 0;
                    k++;
                    continue;
                }
                else
                {
                    int min=Integer.MAX_VALUE,ind=-1;
                    for(int m=k;m<j;m++)
                    {
                        int sum = cost[k][m] + cost[m+1][j] + dim[k-1]*dim[m]*dim[j];
                        if(sum<min)
                        {
                            min = sum;
                            ind = m;
                        }}
                    cost[k][j] = min;
                    path[k][j] = ind;
                    k++;
                }
            }
        }
    }

    static void display(int arr[][])
    {
        for(int i=1;i<arr.length;i++)
        {
            for(int j=1;j<arr.length;j++)
            {
                System.out.print(String.format("%4d ",arr[i][j]));
            }
            System.out.println();
        }
    }
}


