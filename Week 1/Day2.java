// Jewels and Stones
// Solution -   Find the frequency of all the characters in stones string.
//              Traverse through jewels and add the frequency of common characters in the result variable.
// Time Complexity - O(n1 + n2), where n1 is length of jewel string and n2 is length of stones string.
// Space Complexity - O(1). Frequency array is of size 26 which is fixed and does not depend on the value of n.

class Solution {
    public int numJewelsInStones(String J, String S) {
        int[] freqLower = new int[26];
        int[] freqUpper = new int[26];
        
        char[] jewels = J.toCharArray();
        char[] stones = S.toCharArray();
        
        int n1 = J.length();
        int n2 = S.length();
        
        for(int i = 0; i < n2; i++) {
            if(stones[i] >= 'a' && stones[i] <= 'z') {
                freqLower[stones[i] - 'a']++;
            }
            else freqUpper[stones[i] - 'A']++;
        }
        
        int result = 0;
        for(int i = 0; i < n1; i++) {
            if(jewels[i] >= 'a' && jewels[i] <= 'z') {
                result += freqLower[jewels[i] - 'a'];
            }
            else {
                result += freqUpper[jewels[i] - 'A'];
            }
        }
        
        return result;
    }
}