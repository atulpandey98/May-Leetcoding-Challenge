// Jewels and Stones

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