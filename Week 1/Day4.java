// Number Complement
// if input is 5 output is 7 - 5 = 2
// if input is 10 output is 15 - 10 = 5
// So the idea is to find the least power of 2 which is greater than inout number and return the difference.
// Time complexity - O(logn)
// Space complexity - O(1)

class Solution {
    public int findComplement(int num) {
        int i = 1;
        while(num >= Math.pow(2, i)) {
            i++;
        }
        return (int) ((long)Math.pow(2 , i) - 1 - num);
        
    }
}