// Maximum Sum Circular Subarray
// time complexity - O(n)
// maxSum for case 1, when max subarray is in middle.
// minSum for case 2, when max subarray is split across.


class Solution {
    public int maxSubarraySumCircular(int[] A) {
        int totalSum = 0;
        int currMax = 0;
        int currMin = 0;
        int maxSum = Integer.MIN_VALUE;
        int minSum = Integer.MAX_VALUE;
        
        for(int i : A) {
            totalSum += i;
            currMax = Math.max(i, currMax + i);
            maxSum = Math.max(currMax, maxSum);
            currMin = Math.min(i, currMin + i);
            minSum = Math.min(currMin, minSum);
        }
        
        if(maxSum > 0) {
            return Math.max(maxSum, totalSum - minSum);
        }
        return maxSum;              // If all are negative
        
        
    }
}