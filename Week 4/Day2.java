// Interval List Intersection
// Time complexity - O(l1+l2), where l1 and l2 are length of A and B.
// Space complexity - O(1), if output array is not considered.
class Solution {
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        int indexA = 0;
        int indexB = 0;        
        int n1 = A.length;
        int n2 = B.length;
        int low,high;
        List<int[]> list = new ArrayList();        
        while(indexA < n1 && indexB < n2) {
            if(A[indexA][0] < B[indexB][0]) {
                low = B[indexB][0];
            }
            else {
                low = A[indexA][0];
            }
            if(A[indexA][1] < B[indexB][1]) {
                high = A[indexA][1];
                indexA++;
            }
            else if(A[indexA][1] > B[indexB][1]) {
                high = B[indexB][1];
                indexB++;
            }
            else {
                high = B[indexB][1];
                indexA++;
                indexB++;
            }
            if(low <= high){
                list.add(new int[]{low,high});     
            }            
        }      
        return list.toArray(new int[list.size()][]);
    }
}
