class Solution {
    public boolean isGood(int[] nums) {
        int maxx = 0;

        for (int x : nums) {
            maxx = Math.max(maxx, x);
        }


        // size must be mx + 1
        if (nums.length != maxx + 1)
            return false;

        int[] freq = new int[maxx + 1];

        for (int x : nums) {
            // invalid number
            if (x < 1 || x > maxx)
                return false;

            freq[x]++;
        }

        // 1 to mx-1 should appear once
        for (int i = 1; i < maxx; i++) {

            if (freq[i] != 1)
                return false;
        }

        // mx should appear twice
        return freq[maxx] == 2;
    }
}