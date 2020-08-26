package May.May_1_7;

import java.util.*;
import java.util.stream.Collectors;

public class MajorityElement {
    public static void main(String[] args) {
        System.out.println(majorityElement(new int[]{3,2,3})); //3
        System.out.println(majorityElement(new int[]{3,4,3})); //3
    }

    public static int majorityElement(int[] nums) {
        int count = 0;
        int candidate = 0;

        for (int num : nums) {
            if (count == 0) candidate = num;
            count += (num == candidate) ? 1 : -1;
        }

        return candidate;
    }


    public static int majorityElement6(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }


    private static Map<Integer, Integer> countNums(int[] nums) {
        Map<Integer, Integer> counts = new HashMap<>();
        for (int num : nums) {
            if (!counts.containsKey(num)) {
                counts.put(num, 1);
            }
            else {
                counts.put(num, counts.get(num)+1);
            }
        }
        return counts;
    }

    public static int majorityElement5(int[] nums) {
        Map<Integer, Integer> counts = countNums(nums);
        Map.Entry<Integer, Integer> majorityEntry = null;

        for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
            if (majorityEntry == null || entry.getValue() > majorityEntry.getValue()) {
                majorityEntry = entry;
            }
        }

        assert majorityEntry != null;
        return majorityEntry.getKey();
    }

    public static int majorityElement3(int[] nums) {
        int majorityCount = nums.length/2;

        for (int num : nums) {
            int count = 0;
            for (int elem : nums) {
                if (elem == num) {
                    count += 1;
                }
            }

            if (count > majorityCount) {
                return num;
            }
        }
        return -1;
    }

    static public int majorityElement4(int[] nums) {

        if (nums == null || nums.length == 0) {
            return 0;
        }
        return majorityElement(nums, 0);
    }

    private static int majorityElement(int[] nums, int start){
        int count = 1;
        int num = nums[start];
        for(int i = start+1;i<nums.length;i++){
            if(num == nums[i]) count++;
            else count--;
            if(count == 0) return majorityElement(nums,i+1);
        }
        return num;
    }

    static public int majorityElement2(int[] nums) {
        int leader=nums[0],leader_count=1;
        for(int i=1;i<nums.length;i++){
            if(nums[i]==leader) leader_count++;
            else{
                leader_count--;
                if(leader_count==0){
                    if(i<nums.length-1){
                        leader=nums[i+1];
                        leader_count=1;
                        i++;
                    }
                }
            }
        }
        return leader;

    }

    static public int majorityElement1(int[] nums) {

        Map<Integer,Long> map  = Arrays.stream(nums)
                .boxed()
                .collect(Collectors.groupingBy(a->a,Collectors.counting()));

        long max = map.values().stream()
                .max(Comparator.comparingLong(i->i))
                .orElseThrow(RuntimeException::new);

        return map.entrySet().stream()
                .filter(e->e.getValue() == max)
                .map(Map.Entry::getKey)
                .min(Comparator.comparingInt(a->a))
                .orElseThrow(RuntimeException::new);
    }

}
