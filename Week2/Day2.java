// Valid perfect square
// Time complexity - O(1)

class Solution {
    public boolean isPerfectSquare(int num) {
        int tmp = (int)Math.sqrt(num);
        if(tmp * tmp == num)
            return true;
        return false;
    }
}
