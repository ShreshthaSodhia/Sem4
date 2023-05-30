import java.util.*;
public class Main
{
    static int l[][];
    public static int lcs(String x, String y)
    {
        int m = x.length();
        int n = y.length();
        l = new int[m+1][n+1];
        for(int i=0;i<=m;i++)
        {
            for(int j=0;j<=n;j++)
            {
                if(i==0 || j==0)
                {
                    l[i][j]=0;
                }
                else if(x.charAt(i-1)==y.charAt(j-1))
                {
                    l[i][j] = l[i-1][j-1] + 1;
                }
                else
                {
                    l[i][j] = max(l[i-1][j],l[i][j-1]);
                }
            }
        }
        return l[m][n];
    }
    public static int max(int x, int y)
    {
        return (x>y)?x:y;
    }
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter first word: ");
		String x = sc.next();
		System.out.print("Enter second word: ");
		String y = sc.next();
		System.out.println("The longest substring is "+lcs(x,y)+" letters long.");
	}
}
