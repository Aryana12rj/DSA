import java.util.HashSet;
import java.util.Set;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int maxlen = 0;
        int left = 0;

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);

            // If duplicate found, shrink window from left
            while (set.contains(c)) {
                set.remove(s.charAt(left));
                left++;
            }

            // Add current character
            set.add(c);

            // Update max length
            maxlen = Math.max(maxlen, right - left + 1);
        }

        return maxlen;
    }
}
