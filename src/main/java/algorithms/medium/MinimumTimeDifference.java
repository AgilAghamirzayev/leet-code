package algorithms.medium;

import java.util.ArrayList;
import java.util.List;

public class MinimumTimeDifference {

    public static void main(String[] args) {
        List<String> timePoints = new ArrayList<>();
//        timePoints.add("23:58");
//        timePoints.add("00:00");
//        timePoints.add("12:12");
//        timePoints.add("00:13");
//        timePoints.add("23:58");
//        timePoints.add("00:00");

//        System.out.println(differenceTwoTimes("12:12", "00:13")); //719
//        System.out.println(differenceTwoTimes("12:01", "23:59"));
        timePoints.add("01:59");
        timePoints.add("03:00");
        timePoints.add("21:50");
        timePoints.add("22:30");
        MinimumTimeDifference m = new MinimumTimeDifference();
        System.out.println(m.findMinDifference(timePoints));
    }

    public int findMinDifference(List<String> timePoints) {
        int minTime = 1440;

        for (int i = 0; i < timePoints.size(); i++) {
            for (int j = 1 + i; j < timePoints.size(); j++) {
                if (minTime > differenceTwoTimes(timePoints.get(i), timePoints.get(j))) {
                    minTime = differenceTwoTimes(timePoints.get(i), timePoints.get(j));
                }
            }
        }
        return minTime;
    }

    private int differenceTwoTimes(String first, String second) {

        if (Math.abs(Integer.parseInt(first.substring(0, 2)) - Integer.parseInt(second.substring(0, 2))) > 12) {
            final int result = toLocalTimeToMin(first) - (toLocalTimeToMin(second));
            return result > 0 ? 1440 - result : 1440 + result;
        }
        return Math.abs(toLocalTimeToMin(first) - (toLocalTimeToMin(second)));
    }


    private int toLocalTimeToMin(String time) {
        return Integer.parseInt(time.substring(0, 2)) * 60 + Integer.parseInt(time.substring(3, 5));
    }

}
