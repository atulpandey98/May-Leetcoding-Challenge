// Contiguous subarray
// Time Complexity- O(n)
// Space Complexity - O(n)
// Increase count by 1 if the number is 1 or decrease by 1 if it is 0. If we get count which is already in the map, it means 
// that between those 2 indices the number of 0s and 1s are equal and we get length by subtracting these two index values.

class Solution {
    public int findMaxLength(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int count = 0;
        int maxLength = 0;
        for(int i = 0; i < nums.length; i++) {            
            if(nums[i] == 1) {
                count++;
            }
            else {
                count--;
            }
            if(map.containsKey(count)) {
                maxLength = Math.max(maxLength, i - map.get(count));
            }
            else {
                map.put(count, i);
            }
        }
        return maxLength;
    }
}
