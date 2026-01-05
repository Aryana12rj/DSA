class Solution {
    public int mostBooked(int n, int[][] meetings) {
        Arrays.sort(meetings, (a, b) -> a[0] - b[0]);
        int[] roomCounts = new int[n];
        long[] freeTimes = new long[n];
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int[] meeting : meetings) {
            int start = meeting[0];
            int end = meeting[1];

            pq = new PriorityQueue<>();

            for (int i = 0; i < n; i++) {
                if (freeTimes[i] <= start) {
                    pq.add(i);
                }
            }

            if (!pq.isEmpty()) {
                int room = pq.poll();
                roomCounts[room]++;
                freeTimes[room] = end;
            } else {
                long minFreeTime = Long.MAX_VALUE; 
                int minFreeRoom = -1; 

                for (int j = 0; j < n; j++) {
                    if (freeTimes[j] < minFreeTime) {
                        minFreeTime = freeTimes[j];
                        minFreeRoom = j;
                    }
                }
                roomCounts[minFreeRoom]++;
                freeTimes[minFreeRoom] = Math.max(freeTimes[minFreeRoom], start) + (end - start);
            }
        }

        int maxMeetings = 0;
        int mostUsedRoom = 0;

        for (int i = 0; i < n; i++) {
            if (roomCounts[i] > maxMeetings) {
                maxMeetings = roomCounts[i];
                mostUsedRoom = i;
            }
        }

        return mostUsedRoom;
    }
}