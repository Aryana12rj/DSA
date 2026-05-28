class TrieNode {
    TrieNode[] children = new TrieNode[26];
    int best = -1;
    int len = Integer.MAX_VALUE;
}

class Solution {
    private TrieNode root = new TrieNode();
    public int[] stringIndices(String[] wordsContainer, String[] wordsQuery) {
        int minLenIdx = 0;
        for (int i = 0; i < wordsContainer.length; i++) {
            insert(i, wordsContainer[i]);
            if (wordsContainer[i].length() < wordsContainer[minLenIdx].length()) 
                minLenIdx = i;
        }

        int[] res = new int[wordsQuery.length];
        for (int i = 0; i < wordsQuery.length; i++) {
            int idx = search(wordsQuery[i]);
            res[i] = (idx == -1) ? minLenIdx : idx;
        }
        return res;
    }

    private void insert(int idx, String word) {
        TrieNode curr = root;
        for (int i = word.length() - 1; i >= 0; i--) {
            int c = word.charAt(i) - 'a';
            if (curr.children[c] == null) 
                curr.children[c] = new TrieNode();
            curr = curr.children[c];
            if (curr.best == -1 || word.length() < curr.len) {
                curr.best = idx;
                curr.len = word.length();
            }
        }
    }

    private int search(String word) {
        TrieNode curr = root;
        int lastBest = -1;
        for (int i = word.length() - 1; i >= 0; i--) {
            int c = word.charAt(i) - 'a';
            if (curr.children[c] == null) 
                break;
            curr = curr.children[c];
            lastBest = curr.best;
        }
        return lastBest;
    }
}