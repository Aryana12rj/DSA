class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        int n = landStartTime.length;
        int m = waterStartTime.length;
        int minLandEnd = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            minLandEnd = Math.min(minLandEnd, landStartTime[i] + landDuration[i]);
        }
        int option1Finish = Integer.MAX_VALUE;
        for (int j = 0; j < m; j++) {
            int totalTime = Math.max(minLandEnd, waterStartTime[j]) + waterDuration[j];
            option1Finish = Math.min(option1Finish, totalTime);
        }
        int minWaterEnd = Integer.MAX_VALUE;
        for (int j = 0; j < m; j++) {
            minWaterEnd = Math.min(minWaterEnd, waterStartTime[j] + waterDuration[j]);
        }
        int option2Finish = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int totalTime = Math.max(minWaterEnd, landStartTime[i]) + landDuration[i];
            option2Finish = Math.min(option2Finish, totalTime);
        }

        return Math.min(option1Finish, option2Finish);
    }
}