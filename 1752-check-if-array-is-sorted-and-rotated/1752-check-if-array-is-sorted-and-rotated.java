class Solution {
    public boolean check(int[] nums) {
        int n = nums.length;
        for (int k = 0; k < n; k++) {
            if (isSortedAfterRotation(nums, k)) {
                return true;
            }
        }
        return false;
    }
    private boolean isSortedAfterRotation(int[] nums, int k) {
        int n = nums.length;

        for (int i = 0; i < n - 1; i++) {
            int curr = nums[(i + k) % n];
            int next = nums[(i + 1 + k) % n];
            if (curr > next) {
                return false; // break in order
            }
        }
        return true;
    }
}
