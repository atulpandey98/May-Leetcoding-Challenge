// Remove k digits
// Insert the character into stack only of it is greater than or equal to the top element.
// If it is smaller, pop the elements from the and find its correct position.

class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> stack = new Stack<>();
        int n = num.length();
        
        if(n == 0 || n == k) {
            return "0";
        }
        
        for(int i = 0; i < n; i++) {
            char currVal = num.charAt(i);
            while(!stack.isEmpty() && stack.peek() > currVal && k > 0) {
                stack.pop();
                k--;
            }
            stack.push(currVal);
        }
        
        // to handle increasing sequence for eg. "12345"
        while(k > 0) {
            stack.pop();
            k--;
        }
        
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        
        sb.reverse();
        
        // remove leading zeroes
        while(sb.length() > 1 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }
        
        return sb.toString();
    }
}
