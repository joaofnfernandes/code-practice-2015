package skyline_problem;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class Solution {
    private int LINE_X_START;
    private int LINE_X_END;
    private int LINE_Y;
    
    private TreeMap<Integer, int[]> xCoordToBuiding;
    private TreeMap<Integer, int[]> yCoordToBuilding;
    private ArrayList<int[]> resultList;
    
    public List<int[]> getSkyline(int[][] buildings) {
        init();
        
        initXCoordsToBuilding(buildings);
        scanSkyline();
        return resultList;
    }
    
    private void init() {
        LINE_X_START = 0;
        LINE_X_END = 1;
        LINE_Y = 2;
        xCoordToBuiding = new TreeMap<>();
        yCoordToBuilding = new TreeMap<>();
        resultList = new ArrayList<>();
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
