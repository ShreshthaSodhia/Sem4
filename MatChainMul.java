import java.util.*;

public class MatChainMul {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Prompt user for the number of matrices
        System.out.print("Enter number of matrices: ");
        int n = sc.nextInt();
        
        // Initialize arrays
        int[] dims = new int[n + 1];
        int[][] cost = new int[n + 1][n + 1];
        int[][] path = new int[n + 1][n + 1];
        
        // Prompt user for matrix dimensions
        System.out.println("Enter matrix dimensions:");
        for (int i = 0; i < dims.length; i++) {
            System.out.print("Dimension " + i + ": ");
            dims[i] = sc.nextInt();
        }
        
        // Calculate minimum cost and optimal order for matrix chain multiplication
        MCM(dims, cost, path);
        
        // Display results
        System.out.println("\nMinimum cost matrix:");
        displayMatrix(cost);
        System.out.println("\nOptimal order matrix:");
        displayMatrix(path);
    }
    
    /**
     * Calculates minimum cost and optimal order for matrix chain multiplication
     */
    public static void MCM(int[] dims, int[][] cost, int[][] path) {
        int n = dims.length - 1; // number of matrices
        
        // Initialize cost and path arrays
        for (int i = 1; i <= n; i++) {
            cost[i][i] = 0;
        }
        
        for (int l = 2; l <= n; l++) {
            for (int i = 1; i <= n - l + 1; i++) {
                int j = i + l - 1;
                cost[i][j] = Integer.MAX_VALUE;
                for (int k = i; k <= j - 1; k++) {
                    int q = cost[i][k] + cost[k + 1][j] + dims[i - 1] * dims[k] * dims[j];
                    if (q < cost[i][j]) {
                        cost[i][j] = q;
                        path[i][j] = k;
                    }
                }
            }
        }
    }
    
    /**
     * Displays a matrix
     */
    public static void displayMatrix(int[][] matrix) {
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + "\t\t");
            }
            System.out.println();
        }
    }
}
