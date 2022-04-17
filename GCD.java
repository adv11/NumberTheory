package NumberTheory;

import java.util.Arrays;
import java.util.Scanner;

public class GCD {
    static int[][] dp = new int[1001][1001];
    // The idea behind this approach is : subtracting smaller number from bigger number does not change the gcd of
    // the given two numbers.
    // TC = O(max(a, b)) , SC = O(max(a, b))
    public static int gcdEuclideanAlgo(int a, int b){
        if(a == 0) return b;
        if(b == 0) return a;
        if(a == b) return a;
        if(a > b) return gcdEuclideanAlgo(a-b, b);
        return gcdEuclideanAlgo(a, b-a);
    }
    public static int gcdDP(int a, int b){  // TC = O(max(a, b)), SC = O(N)
        for(int i=0 ; i<dp.length ; i++){
            for(int j=0 ; j<dp.length ; j++){
                dp[i][j] = -1;
            }
        }
        if(a == 0) return b;
        if(b == 0) return a;
        if(a == b) return a;
        if(dp[a][b] != -1)
            return dp[a][b];
        if(a > b)
            dp[a][b] = gcdDP(a-b, b);
        else
            dp[a][b] = gcdDP(a, b-a);
        return dp[a][b];
    }
    public static int euclideanOptimised(int a, int b){ // TC = O(log(max(a, b)), SC = O(log(max(a, b))
        if(b == 0)
            return a;
        return euclideanOptimised(b, a%b);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of testcases:");
        int t = sc.nextInt();
        while (t-- > 0){
            System.out.println("Enter the value of a:");
            int a = sc.nextInt();
            System.out.println("Enter the value of b:");
            int b = sc.nextInt();

            System.out.println("Euclidean non-optimised : " + gcdEuclideanAlgo(a, b));
            System.out.println("DP solution : " + gcdDP(a, b));
            System.out.println("Euclidean optimised : " + euclideanOptimised(a, b));

            System.out.println();
        }
    }
}
