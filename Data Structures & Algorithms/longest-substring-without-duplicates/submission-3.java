class Solution {
    public int lengthOfLongestSubstring(String s) {
        // Edge case, length is 0
        if (s.length() == 0)
        return 0;

        // Variables for length and the last viable index
        int maxLen = 0;
        int currLen = 0;
        int lastIndex = 0;

        // HashMap to store the Charactar -> Index
        Map<Character,Integer> h = new HashMap<>();

        // Traversing the string
        for (int i = 0 ; i < s.length(); i++)
        {
            char c = s.charAt(i);
            // Only update lastIndex if the index of the seen character is bigger than last viable index
            if (h.containsKey(c))
            {
               if (lastIndex<h.get(c))
               lastIndex = h.get(c);
               currLen = i - lastIndex;
            }
            else currLen ++;
            h.put(c,i);

            if (currLen > maxLen)
            maxLen = currLen;
        }

        return maxLen;
    }
}
