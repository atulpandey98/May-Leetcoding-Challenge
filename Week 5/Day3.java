// Edit Distance
// If last characters are same, skip them.
// If last characters do not match, we can either delete it from the first word, or replace it, or can add the char 
// from second word.
// Time Complexity - O(n1 * n2).
// Space Complexity - O(n1 * n2).
class Solution {
    int[][] dp;
    public int edit(String s1, String s2, int n1, int n2) {                
        if(n1 == 0) {
            dp[n1][n2] = n2;
            return n2;
        }
        if(n2 == 0) {
            dp[n1][n2] = n1;
            return n1;            
        }
        if(dp[n1][n2] != 0){
            return dp[n1][n2];
        }
        if(s1.charAt(n1-1) == s2.charAt(n2-1)) {
            dp[n1][n2] = edit(s1, s2, n1 - 1, n2 - 1);
        }       
        else {
            dp[n1][n2] = 1 + Math.min(edit(s1, s2, n1 - 1, n2) , Math.min(edit(s1, s2, n1 - 1, n2 - 1) ,                                                     edit(s1,s2,n1,n2-1)));
        }
        return dp[n1][n2];
    }
    
    public int minDistance(String word1, String word2) {
        dp = new int[word1.length() + 1][word2.length() + 1];
        return edit(word1, word2, word1.length(), word2.length());
    }
}
