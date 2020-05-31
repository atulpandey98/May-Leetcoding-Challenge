// K closest points to origin.
// Sort the points in increasing order of their distance and then return first k points.
// Time Complexity - O(nlogn) 

class Solution {
    public int[][] kClosest(int[][] points, int k) {
        Arrays.sort(points, new Comparator<int[]>() {
           public int compare(int[] p1, int[] p2) {
               double d1 = Math.sqrt(p1[1]*p1[1] + p1[0]*p1[0]);
               double d2 = Math.sqrt(p2[1]*p2[1] + p2[0]*p2[0]);
               if(d1 <= d2) {
                   return -1;
               }
               else return 1;
           } 
        });
        int[][] result = new int[k][2];
        for(int i = 0; i < k; i++) {
            result[i] = points[i];
        }
        return result;
    }
}
