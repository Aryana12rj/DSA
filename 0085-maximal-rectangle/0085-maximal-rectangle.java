import java.util.*;

class Solution {
    // Previous Smaller Element
    private int[] psee(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                ans[i] = stack.peek();
            }
            stack.push(i);
        }
        return ans;
    }

    // Next Smaller Element
    private int[] nse(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];
        Arrays.fill(ans, n);
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                ans[i] = stack.peek();
            }
            stack.push(i);
        }
        return ans;
    }

    public int maximalRectangle(char[][] matrix) {
        int rows = matrix.length;
        if (rows == 0) return 0;
        int cols = matrix[0].length;

        int[] arr = new int[cols];
        int maxArea = 0;

        for (int row = 0; row < rows; row++) {
            // Build histogram heights
            for (int col = 0; col < cols; col++) {
                if (matrix[row][col] == '1') {
                    arr[col] += 1;
                } else {
                    arr[col] = 0;
                }
            }

            // Compute largest rectangle in histogram
            int[] pseeArray = psee(arr);
            int[] nseArray = nse(arr);

            for (int i = 0; i < cols; i++) {
                int area = (nseArray[i] - pseeArray[i] - 1) * arr[i];
                maxArea = Math.max(maxArea, area);
            }
        }

        return maxArea;
    }
}
