import java.util.*;

class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        // key = player, value = count of losses
        Map<Integer, Integer> lost_map = new HashMap<>();

        // First pass: count losses
        for (int i = 0; i < matches.length; i++) {
            int loser = matches[i][1];
            lost_map.put(loser, lost_map.getOrDefault(loser, 0) + 1);
        }

        List<Integer> notLost = new ArrayList<>();
        List<Integer> lostOnce = new ArrayList<>();

        // Second pass: check winners and categorize losers
        for (int i = 0; i < matches.length; i++) {
            int winner = matches[i][0];
            int loser = matches[i][1];

            // If winner never recorded in lost_map, he has 0 losses
            if (!lost_map.containsKey(winner)) {
                notLost.add(winner);
                // Mark winner as "visited" so we don’t add again
                lost_map.put(winner, 2); 
            }

            // If loser has exactly one loss, add to lostOnce
            if (lost_map.get(loser) == 1) {
                lostOnce.add(loser);
                // Mark loser as "visited" so we don’t add again
                lost_map.put(loser, 2);
            }
        }

        // Sort results
        Collections.sort(notLost);
        Collections.sort(lostOnce);

        return Arrays.asList(notLost, lostOnce);
    }
}
