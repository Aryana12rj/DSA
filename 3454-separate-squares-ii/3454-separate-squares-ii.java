import java.util.*;

class Solution {
    public double separateSquares(int[][] squares) {
        int n = squares.length;
        
        // Collect all y edges
        List<Integer> ys = new ArrayList<>();
        for (int[] sq : squares) {
            ys.add(sq[1]);
            ys.add(sq[1] + sq[2]);
        }
        Collections.sort(ys);

        // Compute total union area
        double totalArea = unionArea(squares, Integer.MIN_VALUE, Integer.MAX_VALUE);

        // Sweep candidate cut lines
        double bestY = ys.get(0);
        double minDiff = Double.MAX_VALUE;

        for (int y : ys) {
            double above = unionArea(squares, y, Integer.MAX_VALUE);
            double below = totalArea - above;
            double diff = Math.abs(above - below);
            if (diff < minDiff) {
                minDiff = diff;
                bestY = y;
            }
        }

        return bestY;
    }

    // Compute union area of squares clipped between [lowY, highY]
    private double unionArea(int[][] squares, int lowY, int highY) {
        List<int[]> rects = new ArrayList<>();
        for (int[] sq : squares) {
            int x = sq[0], y = sq[1], l = sq[2];
            int y1 = Math.max(y, lowY);
            int y2 = Math.min(y + l, highY);
            if (y1 < y2) {
                rects.add(new int[]{x, y1, x + l, y2});
            }
        }
        if (rects.isEmpty()) return 0.0;

        // Sweep line on x to compute union area
        List<Integer> xs = new ArrayList<>();
        for (int[] r : rects) {
            xs.add(r[0]);
            xs.add(r[2]);
        }
        Collections.sort(xs);

        double area = 0.0;
        for (int i = 0; i < xs.size() - 1; i++) {
            int x1 = xs.get(i), x2 = xs.get(i + 1);
            if (x1 == x2) continue;
            int width = x2 - x1;

            // Find vertical coverage in [x1, x2]
            List<int[]> intervals = new ArrayList<>();
            for (int[] r : rects) {
                if (r[0] <= x1 && r[2] >= x2) {
                    intervals.add(new int[]{r[1], r[3]});
                }
            }
            if (intervals.isEmpty()) continue;

            // Merge intervals
            intervals.sort((a, b) -> a[0] - b[0]);
            int curStart = intervals.get(0)[0], curEnd = intervals.get(0)[1];
            int totalHeight = 0;
            for (int j = 1; j < intervals.size(); j++) {
                if (intervals.get(j)[0] <= curEnd) {
                    curEnd = Math.max(curEnd, intervals.get(j)[1]);
                } else {
                    totalHeight += curEnd - curStart;
                    curStart = intervals.get(j)[0];
                    curEnd = intervals.get(j)[1];
                }
            }
            totalHeight += curEnd - curStart;

            area += width * totalHeight;
        }
        return area;
    }
}
