// First Unique Character in a String
// Idea - make a frequency array for characters and initialise it with -1. If a character occurs for the first time, put it's
//        index in the freq array. If is is occuring more than once, put -2. Then traverse the freq[] and find the min value.
// Time Complexity - O(n), n is size of string.
// Space Complexity - O(1)

class Solution {
public:
    int firstUniqChar(string s) {
        int freq[26];
        for(int i = 0; i < 26; i++) {
            freq[i] = -1;
        }
        for(int i = 0; i < s.length(); i++) {
            if(freq[s[i] - 'a'] == -1) {
                freq[s[i] - 'a'] = i;
            }
            else {
                freq[s[i] - 'a'] = -2;
            }
        }
        int res = INT_MAX;
        for(int i = 0; i < 26; i++) {
            if(freq[i] >= 0) {
                res = min(res, freq[i]);
            }
        }
        if(res == INT_MAX)
            return -1;
        return res;
    }
};
