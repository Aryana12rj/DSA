class Solution {
    public int earliestFinishTime(int[] landStartTime,int[] landDuration,int[] waterStartTime,int[] waterDuration
    ) {
        int n = landStartTime.length;
        int m = waterStartTime.length;
        int ans = Integer.MAX_VALUE;
        int minL = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            minL = Math.min(minL, landStartTime[i] + landDuration[i]);
        }int minW = Integer.MAX_VALUE;
        for (int j = 0; j < m; j++) {
            minW = Math.min(minW, waterStartTime[j] + waterDuration[j]);
        }

        // Step 3: Best land task first, then each water task
        for (int j = 0; j < m; j++) {
            ans = Math.min(ans, Math.max(waterStartTime[j], minL) + waterDuration[j]);
        }

        // Step 4: Best water task first, then each land task
        for (int i = 0; i < n; i++) {
            ans = Math.min(ans, Math.max(landStartTime[i], minW) + landDuration[i]);
        }

        return ans;
    }
}