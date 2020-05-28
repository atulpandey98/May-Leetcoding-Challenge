// Counting Bits
// Time Complexity - O(N)
// count of 1s in a number is equal to count of 1s in half of number. Add 1 if the number is odd.

class Solution {
    public int[] countBits(int num) {
        int[] freq = new int[num + 1];
        freq[0] = 0;
        for(int i = 1; i <= num; i++) {
            freq[i] = freq[i >> 1] + (i & 1);
        }
        return freq;
    }
}
