// Uncrossed lines
// Time complexity - O(m * n)
// space cimplexity - O(m * n)

class Solution {
    public int maxUncrossedLines(int[] A, int[] B) {
        int lengthA = A.length;
        int lengthB = B.length;
        
        int[][] dp = new int[lengthA + 1][lengthB + 1];
        for(int i = 1; i <= lengthA; i++) {
            for(int j = 1; j <= lengthB; j++) {
                if(A[i - 1] == B[j - 1]) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                }
                else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[lengthA][lengthB];
    }
}
