// Naive way would be to count frequency of each element and then return the majority element. O(n^2) - time complexity
// Since it is guranteed that there is a majority element, that means one of it's value must lie at n / 2 position.
// sort the array and return arr[n / 2]
// time complexity - O(nlogn)

class Solution {
public:
    int majorityElement(vector<int>& nums) {
        sort(nums.begin(), nums.end());
        return nums[nums.size() / 2];
    }
};
