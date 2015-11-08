package easy.first_bad_version;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestVersionControl {

    @Test
    public void testVersionMinOddVersions() {
        Solution sol = new Solution();
        boolean[] versionQuality = {false, false, true, true, true, true};
        int expected = 2;
        sol.setVersionQuality(versionQuality);
        assertEquals(expected, sol.firstBadVersion(5));
    }
    
    @Test
    public void testVersionMaxOddVersions(){
        Solution sol = new Solution();
        boolean[] versionQuality = {false, false, false, false, false, true};
        int expected = 5;
        sol.setVersionQuality(versionQuality);
        assertEquals(expected, sol.firstBadVersion(5));
    }
    
    @Test
    public void testVersionMidOddVersions(){
        Solution sol = new Solution();
        boolean[] versionQuality = {false, false, false, true, true, true};
        int expected = 3;
        sol.setVersionQuality(versionQuality);
        assertEquals(expected, sol.firstBadVersion(5));
    }
    @Test
    public void testVersionMinEvenVersions() {
        Solution sol = new Solution();
        boolean[] versionQuality = {false, false, true, true, true, true};
        int expected = 2;
        sol.setVersionQuality(versionQuality);
        assertEquals(expected, sol.firstBadVersion(5));
    }
    
    @Test
    public void testVersionMaxEvenVersions(){
        Solution sol = new Solution();
        boolean[] versionQuality = {false, false, false, false, true};
        int expected = 4;
        sol.setVersionQuality(versionQuality);
        assertEquals(expected, sol.firstBadVersion(4));
    }
    
    @Test
    public void testVersionMidEvenVersions(){
        Solution sol = new Solution();
        boolean[] versionQuality = {false, false, false, true, true};
        int expected = 3;
        sol.setVersionQuality(versionQuality);
        assertEquals(expected, sol.firstBadVersion(4));
    }
    
    @Test
    public void testAllBadVersions(){
        Solution sol = new Solution();
        boolean[] versionQuality = {false, true, true, true};
        int expected = 1;
        sol.setVersionQuality(versionQuality);
        assertEquals(expected, sol.firstBadVersion(3));
    }
}
