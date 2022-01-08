package algorithms.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MinimumTimeDifferenceB {

    public static void main(String[] args) {
        List<String> timePoints = new ArrayList<>();
        timePoints.add("01:59");
        timePoints.add("03:00");
        timePoints.add("21:50");
        timePoints.add("22:30");
        MinimumTimeDifferenceB m = new MinimumTimeDifferenceB();
        System.out.println(m.findMinDifference(timePoints));
    }

    public int findMinDifference(List<String> timePoints) {

        int minimum = 24 * 60;

        List<Integer> minutesList = getMins(timePoints);
        Collections.sort(minutesList);

        int first = minutesList.get(0);
        int prev = minutesList.get(0);
        int last = minutesList.get(minutesList.size() - 1);

        minimum = Math.min(minimum, first + 1440 - last);

        for (int i = 1; i < minutesList.size(); i++) {
            int x = minutesList.get(i) - prev;
            int y = prev + 1440 - minutesList.get(i);
            minimum = Math.min(Math.min(x, y), minimum);
            prev = minutesList.get(i);
        }

        return minimum;
    }

    private List<Integer> getMins(List<String> timePoints) {
        List<Integer> minutesList = new ArrayList<>();
        for (String timePoint : timePoints) {
            minutesList.add(timeToMin(timePoint));
        }
        return minutesList;
    }

    private int timeToMin(String time) {
        return Integer.parseInt(time.substring(0, 2)) * 60 + Integer.parseInt(time.substring(3, 5));
    }
}
