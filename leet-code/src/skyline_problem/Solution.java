package skyline_problem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;

public class Solution {
    private static final int LINE_X_START = 0;
    private static final int LINE_X_END = 1;
    private static final int LINE_Y = 2;
    
    private TreeMap<Integer, int[]> xCoordToBuiding = new TreeMap<>();
    TreeMap<Integer, int[]> yCoordToBuilding = new TreeMap<>();
    ArrayList<int[]> resultList = new ArrayList<>();
    
    public static void main(String[] args) {
        int[][] buildings = {{2,9,10}, {3, 7, 15}, {5, 12, 12}, {15, 20, 10}, {19, 24, 8}};
        List<int[]> results = new Solution().getSkyline(buildings);
        for (int[] result : results) {
            System.out.print(Arrays.toString(result));
        }
    }
    
    public List<int[]> getSkyline(int[][] buildings) {
        initXCoordsToBuilding(buildings);
        scanSkyline();
        return resultList;
    }
    
    /*
     * We scan X coords from left to right
     * If X is the start of a new building, add its Y coord to a tree. If its the max of that tree, print
     * If X is the end of a new building, remove its Y from tree. If it was the max, print
     */
    private void scanSkyline() {
        int[] building;
        int yCoord;
        
        for (Integer xCoord : xCoordToBuiding.navigableKeySet()) {
            building = xCoordToBuiding.get(xCoord);
            yCoord = building[LINE_Y];
            
            if(isBuildingStart(building, xCoord)) {
                yCoordToBuilding.put(yCoord, building);
                if(yCoordToBuilding.lastKey() == yCoord) {
                    addToSkyline(xCoord, yCoord);
                }
            } else {
                boolean wasMax = yCoordToBuilding.lastKey() == yCoord;
                yCoordToBuilding.remove(yCoord);
                if(wasMax) {
                    addToSkyline(xCoord, yFloorOrZero(yCoord));
                }
                
            }
        }
    }
    
    // todo: protect against ill-formed input
    private void initXCoordsToBuilding(int[][] buildings) {
        for (int i = 0; i < buildings.length; i++) {
            xCoordToBuiding.put(buildings[i][LINE_X_START], buildings[i]);
            xCoordToBuiding.put(buildings[i][LINE_X_END], buildings[i]);
        }
    }
    
    private boolean isBuildingStart(int[] building, int x) {
        return building[LINE_X_START] == x;
    }
    
    private int yFloorOrZero(int y) {
        Integer result = yCoordToBuilding.floorKey(y);
        return result == null ? 0 : result;
    }
    
    private void addToSkyline(int x, int y) {
        int[] coord = {x, y};
        resultList.add(coord);
    }
}
