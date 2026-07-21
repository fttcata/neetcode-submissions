class Solution {
    public int characterReplacement(String s, int k) {
        // Map to Store character, frequency mapping
        Map<Character, Integer> h = new HashMap<>();
        
        // Variables for sliding window
        int right = 0;
        int i = 0;
        int maxFreq = 0;
        int maxLen = 0;
        
        // Creating the window
        while (right < s.length())
        {   char c = s.charAt(right);
            // Updating the Frequency
            if (h.containsKey(c))
            {
                h.put(c,h.get(c) + 1);
            }
            else
            h.put(c,1);    
            // Updating maxFreq
             if (h.get(c) > maxFreq)
                maxFreq = h.get(c);   

            // Checking if window size is bigger than k
            if (right - i + 1 - maxFreq > k)
            {
            // If yes, shrink window
            c = s.charAt(i);
            h.put(c, h.get(c)-1);
            i++;
            }

            // Comparing windows size to maxLen
            if (Math.max(maxLen, right - i + 1) > maxLen)
            maxLen = Math.max(maxLen, right - i + 1);

            right++;     
        }

        return maxLen;
    }
}
