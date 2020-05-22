// Single element in a sorted array
// Use the property of XOR, A ^ A = 0.
// Time complexity - O(n) 

class Solution {
    public int singleNonDuplicate(int[] nums) {
        int answer = 0;
        for(int i : nums) {
            answer = answer ^ i;
        }
        return answer;
    }
}
