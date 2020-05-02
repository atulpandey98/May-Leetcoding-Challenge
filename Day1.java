// First Bad Version

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int low = 1;
        int high = n;
        int mid = (high - low) / 2 + low;
        while(low < high) {
            if(isBadVersion(mid)) {
                high = mid;
            }   
            else {
                low = mid + 1;
            }
            mid = (high - low) / 2 + low;
        }
        return high;
        
    }
}