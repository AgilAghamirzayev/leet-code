package algorithms.easy;

import java.util.Arrays;

public class TwoSum {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{2, 7, 11, 15}, 9)));
        System.out.println(Arrays.toString(twoSum(new int[]{3, 2, 3}, 6)));
    }

    // best case

    public static int[] twoSum(int[] nums, int target) {
        int max = 2047;
        int temp;

        int[] test = new int[2048];
        for (int i = 0; i < nums.length; i++) {
            temp = max & (target - nums[i]);
            if (test[temp] != 0) return new int[]{test[temp] - 1, i};
            test[max & nums[i]] = i + 1;
        }
        throw new RuntimeException("No two sum solution");
    }


    public static int[] twoSum1(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) return new int[]{i, j};
            }
        }
        throw new RuntimeException("No two sum solution");
    }
}
