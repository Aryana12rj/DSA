class Solution {
    public int longestPalindrome(String s) {
        if (s == null || s.length() == 0) return 0;

        HashSet<Character> hs = new HashSet<>();
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i); 
            if (hs.contains(ch)) {
                count++;
                hs.remove(ch); // remove to complete the pair
            } else {
                hs.add(ch);
            }
        }

        // If there are leftover characters, we can place one in the middle
        if (!hs.isEmpty()) return count * 2 + 1;
        return count * 2;
    }
}
