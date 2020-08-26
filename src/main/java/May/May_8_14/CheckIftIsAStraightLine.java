package May.May_8_14;

import java.util.Arrays;

public class CheckIftIsAStraightLine {


    public static boolean checkStraightLine(int[][] coordinates) {

        int x0 = coordinates[0][0];
        int y0 = coordinates[0][1];
        int x1 = coordinates[1][0];
        int y1 = coordinates[1][1];
        int dx = x1-x0;
        int dy = y1-y0;

        for (int[] co: coordinates){
            int x = co[0];
            int y = co[1];
            if (dx * (y - y1) != dy*(x-x1)) return false;
        }
        return true;
    }

    public static boolean checkStraightLine1(int[][] coordinates) {
        int[] point1 = coordinates[1];
        int[] point2 = coordinates[0];
        float gSlope = slope(point1,point2);

        for (int i = 1; i < coordinates.length; i++) {
            int[] p1 = coordinates[i];
            int[] p2 = coordinates[0];
            float slop = slope(p1, p2);
            if (gSlope != slop) return false;
        }
        return true;
    }

    private static float slope(int[] p1, int[] p2) {
        if ((p1[0] - p2[0]) == 0) return 0;
        return (float) (p2[1] - p1[1]) / (p2[0] - p1[0]);
    }

    public static void main(String[] args) {
        System.out.println(checkStraightLine(new int[][]{
                {1,2},{2,3},{3,4},{4,5},{5,6},{6,7}
        }));

        System.out.println(checkStraightLine(new int[][]{
                {1,1},{2,2},{3,4},{4,5},{5,6},{7,7}
        }));

        System.out.println(checkStraightLine(new int[][]{
                {-3,-2},{-1,-2},{2,-2},{-2,-2},{0,-2}
        }));

        System.out.println(checkStraightLine(new int[][]{
                {0,1},{1,3},{-4,-7},{5,11}
        }));

    }
}
