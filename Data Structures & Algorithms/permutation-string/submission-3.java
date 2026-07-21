class Solution {
    public boolean checkInclusion(String s1, String s2) {
       // Edge case
       if (s1.length() > s2.length())
       return false;

      // When the current window size is equal to s1 length, we check if they freqArrays match 

       int[] freqS1 = new int[26];

       for (int i = 0 ; i < s1.length(); i++)
       {
        freqS1[s1.charAt(i) - 'a']++;
       }

       // Traverse s2
       int left = 0;
       int right = 0;

       int[] freqS2 = new int[26];
       while (right < s2.length())
       {
            freqS2[s2.charAt(right) -'a']++;

            // If the current substring is equal to s1 in length
            if (right - left + 1 == s1.length())
            {
            // Check if they match
            for (int i = 0 ; i < 26; i++)
            {
                if (freqS1[i] != freqS2[i])
                break;
                if (i == 25)
                return true;
            }
            freqS2[s2.charAt(left) - 'a']--;
            left++;
            }
            
            right++;
        }

       return false;

    }
}