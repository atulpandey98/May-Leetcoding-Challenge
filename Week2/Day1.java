// Check if it a straight line
// Find slope from first 2 points, and then traverse through the array of coordinates.
// If any two point's slope is not equal to required slope, return false, else return true.
// Time complexity - O(n), only one traversal of the array.
class Solution {
    public boolean checkStraightLine(int[][] coordinates) {
        double slope = calculateSlope(coordinates[0][0], coordinates[0][1], coordinates[1][0],                                        coordinates[1][1]);
        int length = coordinates.length;
        boolean result = true;
        for(int i = 2; i < length; i++) {
            double tmp = calculateSlope(coordinates[i - 1][0], coordinates[i - 1][1], coordinates[i][0],                                        coordinates[i][1]);
            if(tmp != slope){
                result = false;
                break;
            }
                
        }
        return result;
    }
    double calculateSlope(int x1, int y1, int x2, int y2) {
        return (y2 - y1) / (double)(x2 - x1);
    }
}
