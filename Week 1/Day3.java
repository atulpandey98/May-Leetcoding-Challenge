// count the frequency of characters in both the strings. If each character in ransomNote have equal or more frequency in 
// magazine, then we return true else false.

class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {        
        final int SIZE = 26;        
        int[] freqMagazine = new int[SIZE];
        int[] freqRansom = new int[SIZE];
        for(char c : magazine.toCharArray()) {
            freqMagazine[c - 'a']++; 
        }
        for(char c : ransomNote.toCharArray()) {
            freqRansom[c - 'a']++;
        }
        for(int i = 0; i < SIZE; i++) {
            if(freqRansom[i] > freqMagazine[i])
                return false;
        }
        return true;
    }
}