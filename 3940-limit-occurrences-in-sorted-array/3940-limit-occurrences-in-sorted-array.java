import java.util.*;

class Solution {
    public int[] limitOccurrences(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        List<Integer> result = new ArrayList<>();

        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
            if (count.get(num) <= k) {
                result.add(num);
            }
        }

        // Convert List<Integer> → int[]
        int[] ans = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            ans[i] = result.get(i);
        }

        return ans;
    }
}
