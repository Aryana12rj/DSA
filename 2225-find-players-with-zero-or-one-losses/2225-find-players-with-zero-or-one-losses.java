import java.util.*;

class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        // key = player, value = count of losses
        Map<Integer,Integer> lost_map = new HashMap<>();

        // First pass: count losses
        for (int i = 0; i < matches.length; i++) {
            int loser = matches[i][1];
            // increment loss count for loser
            lost_map.put(loser, lost_map.getOrDefault(loser, 0) + 1);
        }

        // Second pass: ensure winners are tracked (with 0 losses if not already)
        for (int i = 0; i < matches.length; i++) {
            int winner = matches[i][0];
            if (!lost_map.containsKey(winner)) {
                lost_map.put(winner, 0);
            }
        }

        // Prepare result lists
        List<Integer> notLost = new ArrayList<>();
        List<Integer> lostOnce = new ArrayList<>();

        // Categorize players
        for (Map.Entry<Integer,Integer> entry : lost_map.entrySet()) {
            int player = entry.getKey();
            int losses = entry.getValue();

            if (losses == 0) {
                notLost.add(player);
            } else if (losses == 1) {
                lostOnce.add(player);
            }
        }

        // Sort results
        Collections.sort(notLost);
        Collections.sort(lostOnce);

        // Final answer
        List<List<Integer>> answer = new ArrayList<>(2);
        answer.add(notLost);
        answer.add(lostOnce);

        return answer;
    }
}
