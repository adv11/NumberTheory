package NumberTheory;
import java.util.Scanner;

public class Fibonacci {
    public static int recursiveFibonacci(int n){    // TC = O(N), SC = O(N)
        if(n <= 1)
            return n;
        return recursiveFibonacci(n-1) + recursiveFibonacci(n-2);
    }
    public static int dpFibonacci(int n){   // TC = O(N), SC = O(N)
        int[] fib = new int[n+2];
        fib[0] = 0;
        fib[1] = 1;
        for(int i=2 ; i<=n ; i++){
            fib[i] = fib[i-1] + fib[i-2];
        }
        return fib[n];
    }
    public static int iterativeFibonacci(int n){    // TC = O(N), Sc = O(1)
        int t1 = 0, t2 = 1, sum = 0;
        if(n == 0)
            return t1;
        for(int i=2 ; i<=n ; i++){
            sum = t1 + t2;
            t1 = t2;
            t2 = sum;
        }
        return t2;
    }
    public static int formulaBasedFibonacci(int n){ // TC = O(1), Sc = O(1)
        double phi = (1 + Math.sqrt(5)) / 2;
        return (int) Math.round(Math.pow(phi, n) / Math.sqrt(5));
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of testcase:");
        int t = sc.nextInt();
        while (t-- > 0){
            System.out.println("Enter the value of N:");
            int n = sc.nextInt();

            System.out.println("Recursive solution : " + recursiveFibonacci(n));
            System.out.println("DP solution : " + dpFibonacci(n));
            System.out.println("Iterative solution : " + iterativeFibonacci(n));
            System.out.println("Formula Based solution : " + formulaBasedFibonacci(n));

            System.out.println();
        }
    }
}
