// Permutation in string
// Time Complexity - O(n)
// Sliding window technique. Watch previous solution (Anagrams of a string) 

class Solution {
    int[] pFreq;
    int[] sFreq ;
    public boolean checkInclusion(String p, String s) {
        int sLength = s.length();
        int pLength = p.length();        
        if(sLength < pLength) {
            return false;
        }
        pFreq = new int[26];
        sFreq = new int[26];
        for(int i = 0; i < pLength; i++) {            
            pFreq[p.charAt(i) - 'a']++;
            sFreq[s.charAt(i) - 'a']++;
        }                
        boolean runningAna = false;
        if(isAnagram()) {                        
            return true;
        }
        for(int i = 1; i <= sLength - pLength; i++) {
            char prev = s.charAt(i - 1);
            char next = s.charAt(i + pLength - 1);            
            if(prev != next) {
                sFreq[prev - 'a']--;
                sFreq[next - 'a']++;
                if(isAnagram()) {                        
                    return true;
                }
            }            
        }
        return false;
    }
    public boolean isAnagram() {        
        for(int i = 0; i < 26; i++) {            
            if(sFreq[i] != pFreq[i]) {                
                return false;
            }
        }
        return true;
    }    
}
