// Find the town judge.
// Time complexity - O(n ^ 2) 

class Solution {
    public int findJudge(int N, int[][] trust) {
        ArrayList<Integer>[] arr = new ArrayList[N]; // Create an array of ArrayList.
        
        for(int i = 0; i < N; i++) {
            arr[i] = new ArrayList<>();  // Initialise the array.
        }
        
        int tLength = trust.length;
        for(int i = 1; i <= tLength; i++) {
            arr[trust[i - 1][0] - 1].add(trust[i - 1][1] - 1); // At each index, add the persons whom they trust
        }
        
        int judge = -1;
        int flag1 = 0;
        
        for(int i = 0; i < N; i++) {
            if(arr[i].size() == 0 && flag1 == 1) {  // found more than 1 judge candidates, not possible.
                return -1;
            }
            if(arr[i].size() == 0) {
                judge = i;
                flag1 = 1;
            }
        }      
        
        for(int i = 0; i < N; i++) {
            int flag = 0;
            for(int element : arr[i]) {   
                if(element == judge) {
                    flag = 1;
                    break;
                }
            }
            if(flag != 1 && i != judge) {    // the single judge contender also trusts someone, return -1.
                return -1;
            }
        }
        return judge + 1; // found the judge.
    }
}
