class Solution {
    public int numberOfSubstrings(String s) {
        // Frequency array for 'a', 'b', 'c'
        int fre[] = new int[3];  
        
        int count = 0;       // total substrings containing all 3 chars
        int currcount = 0;   // how many distinct chars currently in window
        int left = 0;        // left pointer of sliding window
        int n = s.length();  // length of input string

        // Expand window with right pointer
        for (int right = 0; right < n; right++) {
            char ch = s.charAt(right);
            fre[ch - 'a']++;  // include current char in frequency

            // If this char appears for the first time in window
            if (fre[ch - 'a'] == 1) {
                currcount++;
            }

            // Shrink window until it no longer has all 3 distinct chars
            while (currcount == 3) {
                // Every substring starting at 'left' and ending at >= right
                // will contain all 3 chars → add (n - right) to count
                count += (n - right);

                // Remove leftmost char from window
                char cha = s.charAt(left);
                fre[cha - 'a']--;
                if (fre[cha - 'a'] == 0) {
                    currcount--; // lost one distinct char
                }
                left++; // move window forward
            }
        }
        return count;
    }
}
