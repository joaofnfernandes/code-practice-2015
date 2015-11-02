package compare_versions;

public class Solution {
    public int compareVersion(String version1, String version2) {
        String[] version1Digits = version1.split("\\.");
        String[] version2Digits = version2.split("\\.");
        Integer digitVersion1, digitVersion2;
        int i = 0;
        while(i < Math.max(version1Digits.length, version2Digits.length)) {
            if(i >= version1Digits.length) {
                digitVersion2 = Integer.parseInt(version2Digits[i]);
                if(digitVersion2 != 0) {
                    return -1;
                }
            } else if(i >= version2Digits.length) {
                digitVersion1 = Integer.parseInt(version1Digits[i]);
                if(digitVersion1 != 0) {
                    return 1;
                }
            } else {
                digitVersion1 = Integer.parseInt(version1Digits[i]);
                digitVersion2 = Integer.parseInt(version2Digits[i]);
                if(digitVersion1 < digitVersion2) {
                    return -1;
                } else if(digitVersion1 > digitVersion2) {
                    return 1;
                }
            }
            i++;
        }
        return 0;
    }
}