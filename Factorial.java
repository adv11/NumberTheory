package NumberTheory;
import java.util.Scanner;

public class Factorial {
    static int[] dp = new int[1000];
    // TC : O(N), SC : O(N)
    public static int recursiveFactorial(int n){
        if(n==0 || n==1){
            return 1;
        }
        return n * recursiveFactorial(n-1);
    }
    // TC : O(N), SC = O(1)
    public static int iterativeFactorial(int n){
        int res = 1;
        for(int i=2 ; i<=n ; i++){
            res *= i;
        }
        return res;
    }
    // TC : O(N), SC : O(N)
    public static int dpFactorial(int n){
        dp[0] = 1;
        for(int i=1 ; i<=n ; i++){
            dp[i] = i * dp[i-1];
        }
        return dp[n];
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of test cases:");
        int t = sc.nextInt();
        while (t-- > 0){
            System.out.println("Enter the value of N:");
            int n = sc.nextInt();

            System.out.println("Recursive solution : " + recursiveFactorial(n));
            System.out.println("Iterative solution : " + iterativeFactorial(n));
            System.out.println("DP solution : " + dpFactorial(n));
            System.out.println();
        }
    }
}
