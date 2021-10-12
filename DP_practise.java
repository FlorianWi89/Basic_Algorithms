public class DP_practise {

    // Given 3 numbers {1, 3, 5}, we need to tell the total number of ways we can
    // form a number 'N'
    // using the sum of the given three numbers.(allowing repetitions and different
    // arrangements).

    static int[] table = new int[100];

    // exp time because some arguments are calculated more than once
    static int bruteForce(int n) {
        if (n < 0)
            return 0;

        if (n == 0)
            return 1;

        return bruteForce(n - 1) + bruteForce(n - 3) + bruteForce(n - 5);
    }

    // this is a DP solution using memoization

    static int solve(int n) {
        if (n < 0)
            return 0;
        if (n == 0)
            return 1;

        if (table[n] != 0)
            return table[n];

        return table[n] = solve(n - 1) + solve(n - 3) + solve(n - 5);
    }

    // expample problem: longest common subsequence

    static int max(int x, int y) {
        return (x > y) ? x : y;
    }

    // calculating lcs using bottop up ( tabulation)

    static int lcs(char[] stringA, int lenA, char[] stringB, int lenB) {

        int[][] L = new int[lenA + 1][lenB + 1];

        for (int i = 0; i < lenA; i++) {
            for (int j = 0; j < lenB; j++) {
                if (i == 0 || j == 0) {
                    L[i][j] = 0;
                } else if (stringA[lenA - 1] == stringB[lenB - 1]) {
                    L[i][j] = L[i - 1][j - 1] + 1;
                } else {
                    L[i][j] = max(L[i - 1][j], L[i][j - 1]);
                }
            }
        }
        return L[lenA][lenB];
    }
}
