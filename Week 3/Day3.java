// Find all anagrams of a string
// Time complexity - O(n)
// Use window sliding technique and check for anagram only when new character is not equal to the previous 
// character of the window.

class Solution {
    
    int[] pFreq;
    int[] sFreq ;
    public List<Integer> findAnagrams(String s, String p) {
        int sLength = s.length();
        int pLength = p.length();
        List<Integer> list = new ArrayList<>();
        if(sLength < pLength) {
            return list;
        }
        pFreq = new int[26];
        sFreq = new int[26];
        for(int i = 0; i < pLength; i++) {            
            pFreq[p.charAt(i) - 'a']++;
            sFreq[s.charAt(i) - 'a']++;
        }                
        boolean runningAna = false;
        if(isAnagram()) {            
            runningAna = true;
            list.add(0);
        }
        for(int i = 1; i <= sLength - pLength; i++) {
            char prev = s.charAt(i - 1);
            char next = s.charAt(i + pLength - 1);
            if(runningAna) {
                if(prev == next) {
                    list.add(i);
                }
                else {
                    runningAna = false;
                    sFreq[prev - 'a']--;
                    sFreq[next - 'a']++;
                }
            }
            else {
                if(prev != next) {
                    sFreq[prev - 'a']--;
                    sFreq[next - 'a']++;
                    if(isAnagram()) {
                        runningAna = true;
                        list.add(i);
                    }
                }
            }
        }
        return list;
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
