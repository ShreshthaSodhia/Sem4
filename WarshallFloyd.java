import java.util.*;
class WarshallFloyd
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter number of vertices of graph");
        int nv=sc.nextInt();
        int graph[][]=new int[nv][nv];
        for(int i=0;i<nv;i++)
        {
            for(int j=0;j<nv;j++)
            {
                if(i==j)
                {
                    graph[i][j]=0;
                    continue;
                }
                System.out.println("Enter distance if edge exists between between "+(i+1)+" and "+(j+1));
                graph[i][j]=sc.nextInt();
                //taking infinity=99999
                if(graph[i][j]==0 && i!=j)
                {
                    graph[i][j]=99999;
                }
            }
        }
        System.out.println("THE GRAPH IS");
        for(int i=0;i<nv;i++)
        {
            for(int j=0;j<nv;j++)
            {
                System.out.print(graph[i][j]+"\t\t");
               
            }
            System.out.println("\n");
        }  
        WarshallFloyd wfg=new WarshallFloyd();
        wfg.warfloy(graph);
        sc.close();
    }
    public void warfloy(int graph[][])
    {
        int nv=graph.length;
        int dist[][]=new int[nv][nv];
        for(int i=0;i<nv;i++)
        {
            for(int j=0;j<nv;j++)
            {
                dist[i][j]=graph[i][j];
            }
        }
        int k;
        for(k=0;k<nv;k++)
        {
            for(int i=0;i<nv;i++)
            {
                for(int j=0;j<nv;j++)
                {
                    if(dist[i][j]>dist[i][k]+dist[k][j])
                    {
                        dist[i][j]=dist[i][k]+dist[k][j];
                    }
                }
            }
            System.out.println("D"+(k+1)+"=");
            for(int i=0;i<nv;i++)
            {
                for(int j=0;j<nv;j++)
                {
                    System.out.print(dist[i][j]+"\t\t");
                   
                }
                System.out.println("\n");
            }  
        }
        System.out.println("THE SHORTEST PATHS ARE");
        for(int i=0;i<nv;i++)
        {
            for(int j=0;j<nv;j++)
            {
                System.out.print(dist[i][j]+"\t\t");
               
            }
            System.out.println("\n");
        }
    }
}