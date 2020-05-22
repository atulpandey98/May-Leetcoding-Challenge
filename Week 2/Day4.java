// Flood fill.
// Do a depth first search, and change the value to newcolor.
// maintain a visited array to avoid stack overflow.
// Time complexity - O(n)  

class Solution {
    int[][] visited;
    int rows;
    int columns;
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        rows = image.length;
        columns = image[0].length;
        visited = new int[rows][columns];
        fill(image, sr, sc, newColor);
        return image;
    }
    void fill(int[][] image, int sr, int sc, int newColor) {
        if(visited[sr][sc] == 0) {
            visited[sr][sc] = 1;
            if(sr > 0 && image[sr-1][sc] == image[sr][sc]) {                
                fill(image, sr - 1, sc, newColor);
            }
            if(sr < rows-1 && image[sr+1][sc] == image[sr][sc]) {                
                fill(image,sr + 1, sc,newColor);
            }
            if(sc > 0 && image[sr][sc-1] == image[sr][sc]) {                
                fill(image, sr, sc-1, newColor);
            }
            if(sc < columns-1 && image[sr][sc+1] == image[sr][sc]) {                
                fill(image,sr, sc + 1,newColor);
            }
            image[sr][sc] = newColor;
        }
    }
}
