public class MatrixChainMult_using_DP {

    // matrix Ai has dimensions of a[i-1]xa[i]
    static int MatrixMult(int[] matrices, int n) {
        int[][] m = new int[n][n];

        int i, j, k, L, q;

        /*
         * m[i, j] = Minimum number of scalar multiplications needed to compute the
         * matrix A[i]A[i+1]...A[j] = A[i..j] where dimension of A[i] is matrices[i-1] x
         * matrices[i]
         */

        // cost is zero when multiplying one matrix
        for (i = 1; i < n; i++)
            m[i][i] = 0;

        // L is chain length
        for (L = 2; L < n; L++) {
            for (i = 1; i < n; i++) {
                j = i + L - 1;
                if (j == n)
                    continue;

                m[i][j] = Integer.MAX_VALUE;
                for (k = i; k <= j - 1; k++) {

                    // cost per scalar multiplikations
                    q = m[i][k] + m[k + 1][j] + matrices[i - 1] * matrices[k] * matrices[j];
                    if (q < m[i][j])
                        m[i][j] = q;
                }
            }
        }
        return m[1][n - 1];
    }
}