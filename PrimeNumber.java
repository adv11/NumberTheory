package NumberTheory;

import java.util.Arrays;
import java.util.Scanner;

public class PrimeNumber {
    static int i = 2;
    static boolean[] isPrime = new boolean[100000];
    public static boolean recursivePrime(int n){    // TC = O(N), SC = O(N)
        if(n == 0 || n == 1)
            return false;
        if(n == i) return true;
        if(n % i == 0) return false;
        i++;
        return recursivePrime(n);
    }
    // TC = O(N), SC = O(1)
    public static boolean naiveApproach(int n){
        if(n <= 1)
            return false;
        for(int i=2 ; i<n ; i++){
            if(n % i == 0){
                return false;
            }
        }
        return true;
    }
    // TC = O(sqrt(N)), SC = O(1)
    public static boolean sqrtApproach(int n){
        if(n <= 1)
            return false;
        for(int i=2 ; i*i<=n ; i++){
            if(n % i == 0){
                return false;
            }
        }
        return true;
    }
    // Sieve of Eratosthenes Approach : TC = O
    public static boolean sieveApproach(int n){
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;
        for(int i=2 ; i*i<=n ; i++){
            for(int j=2*i ; j<=n ; j+=i){
                isPrime[j] = false;
            }
        }
        return isPrime[n];
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of test cases:");
        int t = sc.nextInt();
        while (t-- > 0){
            System.out.println("Enter the value of n");
            int n = sc.nextInt();

            System.out.println("Recursive Approach : " + recursivePrime(n));
            System.out.println("Naive Approach : " + naiveApproach(n));
            System.out.println("Sqrt Approach : " + sqrtApproach(n));
            System.out.println("Sieve Approach : " + sieveApproach(n));

            System.out.println();
        }
    }
}
