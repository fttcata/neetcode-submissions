class Solution {
    public boolean checkInclusion(String s1, String s2) {
        // Edge case, input string longer than the string in which we're looking for it
        if (s1.length() > s2.length())
        return false;

        // Only lowercase letters, frequency array
        int[] freq = new int[26];

        // Adding all characters of s1 into a set
        for (int i = 0 ; i < s1.length(); i++)
        {
            freq[s1.charAt(i) - 'a']++;
        }

        int i = 0;

        // Traversing the string
        while (i < s2.length())
        {
            char c = s2.charAt(i);
            int right = i;
            // Frequency array for sliding window
            int[] window = new int[26];
            // Building frequency array for sliding window
            if (freq[s2.charAt(i) - 'a'] != 0)
            {
            while (right < s2.length() && right - i < s1.length())
            {
                window[s2.charAt(right) - 'a'] ++;
                right++;
            }
            // Checking if frequencies match
            for (int j = 0 ; j < 26; j++)
            {
                if (freq[j] != window[j])
                break;
                if (j == 25)
                return true;
            }
            }
            i++;
        }

        // If haven't reached true, then return false
        return false;
    }
}
