package easy.first_bad_version;

public class Solution extends VersionControl {
    // a less efficient solution
    public int firstBadVersion2(int n) {
        while(n > 0 && isBadVersion(n)) {
            n = n/2;
        }
        while(!isBadVersion(n)) {
            n++;
        }
        return n;
    }
    
    // a binary search
    public int firstBadVersion(int n) {
        int maxVersion = n - 1, minVersion = 0,
            midVersion = minVersion + ((maxVersion - minVersion) / 2);
        boolean midIsBad;
        do {
            midIsBad = isBadVersion(midVersion + 1);
            if (midIsBad) {
                maxVersion = midVersion;
            } else {
                minVersion = midVersion;
            }
            midVersion = minVersion + ((maxVersion - minVersion) / 2);
        } while (midVersion > minVersion);
        return isBadVersion(minVersion + 1) ? minVersion + 1 : maxVersion + 1;
    }

    @Override
    boolean isBadVersion(int version) {
        return values[version];
    }
    
    private boolean[] values = null;
    void setVersionQuality(boolean[] values) {
        this.values = values;
    }
}