package algorithms.math;

public class PrimeNumber {
    
    public static void main(String[] args) {
    
    }

    /*
    * 判断是否为质数
    * */
    public static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
    
    /*
    * 埃拉托斯特尼筛法
    * 获取[0, n)范围内所有的质数
    * */
    public static boolean[] sieveOfEratosthenes(int n) {
        boolean[] isPrime = new boolean[n];
        for (int i = 2; i < n; i++) {
            isPrime[i] = true;
        }
        for (int i = 2; i * i < n; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j < n; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        return isPrime;
    }
}
