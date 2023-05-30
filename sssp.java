public class sssp{

    public void dijkstra(int [][] arr, int source){
        int count = arr.length;
        boolean[] visited = new boolean[count];
        int[] distance = new int[count];
        for(int i = 0; i<count; i++){
            visited[i] = false;
            distance[i] = Integer.MAX_VALUE;
        }
        distance[source] = 0;
       
        for(int i = 0; i<count; i++){
            int u = mindistance(distance, visited);
            visited[u] = true;
            for(int j = 0; j<count; j++){
                if(!visited[j] && arr[u][j] != 0 && (distance[u]+ arr[u][j] < distance[j])){
                    distance[j] = distance[u] + arr[u][j];
                }
            }
        }
        System.out.println("Vertex \t Distance from Source");
        for(int i = 0; i<distance.length; i++){
            System.out.println(i + "\t "+ distance[i]);
        }
    }

    public static int mindistance(int[] distance, boolean[] visited){
        int mindistance = Integer.MAX_VALUE;
        int minvertex = -1;
        for (int i = 0; i < distance.length; i++) {
            if (!visited[i] && distance[i] < mindistance) {
                mindistance = distance[i];
                minvertex = i;
            }
          }
          return minvertex;
    }

    public static void main(String[] args) {
        int arr[][] = new int [][]{ { 0, 4, 0, 0, 0, 0, 0, 8, 0 },
        { 4, 0, 8, 0, 0, 0, 0, 11, 0 },
        { 0, 8, 0, 7, 0, 4, 0, 0, 2 },
        { 0, 0, 7, 0, 9, 14, 0, 0, 0 },
        { 0, 0, 0, 9, 0, 10, 0, 0, 0 },
        { 0, 0, 4, 14, 10, 0, 2, 0, 0 },
        { 0, 0, 0, 0, 0, 2, 0, 1, 6 },
        { 8, 11, 0, 0, 0, 0, 1, 0, 7 },
        { 0, 0, 2, 0, 0, 0, 6, 7, 0 } };
        sssp D = new sssp();
        D.dijkstra(arr, 0);
    }
}
