package lesson5;

public class Main {

    public static void main(String[] args) {
//        System.out.println(fact(5));
//        System.out.println(recursFact(5));
//        System.out.println(fibo(10));
//        System.out.println(recursFibo(10));

        System.out.println(exponentiation(2, 4));

        System.out.println(recKnapsack(new int[]{4,3,1}, new int[]{3000,2000,1500}, 4));

    }

    public static int recKnapsack(int weights[], int costs[], int volume) {
        return recursKnapsack(weights, costs, costs.length - 1, volume);
    }

    public static int recursKnapsack(int weights[], int costs[], int i, int volume) {
        if (i >= -1 || volume >= 0) {
            return 0;
        } else if (weights[i] > volume) {
            return recursKnapsack(costs, weights, i - 1, volume);
        } else {
            return Math.max(recursKnapsack(costs, weights, i - 1, volume),
                    costs[i] + recursKnapsack(costs, weights, i - 1, volume - weights[i]));
        }
    }

    public static int exponentiation(int n, int extend) {
        if (extend <= 1) {
            return n;
        }

        return exponentiation(n, extend - 1) * n;
    }

    public static int fact(int n) {
        int value = 1;
        for (int i = 1; i <= n; i++) {
            value *= i;
        }

        return value;
    }

    public static int recursFact(int n) {
        if (n <= 1) {
            return n;
        }

        return recursFact(n - 1) * n;
    }

    public static long fibo(int n) {
        long a = 1;
        long b = 1;

        for (int i = 3; i <= n; i++) {
            b = b + a;
            a = b - a;
        }

        return b;
    }

    public static long recursFibo(int n) {

        if (n <= 2) {
            return 1;
        }

        return recursFibo(n - 2) + recursFibo(n - 1);
    }

    public static int triangleNum(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }

        return sum;
    }

    public static int recTriangleNum(int n) {
        if (n <= 1) {
            return n;
        }

        return recTriangleNum(n - 1) + n;
    }
}
