class Solution {

    public int minimumEffort(int[][] tasks) {

        Arrays.sort(tasks, (a, b) ->
            (b[1] - b[0]) - (a[1] - a[0])
        );

        long ans = 0;
        long energy = 0;

        for (int i = 0; i < tasks.length; i++) {

            int actual = tasks[i][0];
            int minimum = tasks[i][1];

            if (energy < minimum) {
                ans += (minimum - energy);
                energy = minimum;
            }

            energy -= actual;
        }

        return (int) ans;
    }
}