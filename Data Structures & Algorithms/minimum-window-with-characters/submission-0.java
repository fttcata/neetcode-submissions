class Solution {
    public String minWindow(String s, String t) {

        if (t.length() > s.length()) return "";

        Map<Character, Integer> freqMap = new HashMap<>();

        for (char c : t.toCharArray()) {
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }

        Map<Character, Integer> windowMap = new HashMap<>();

        int i = 0; // right pointer
        int j = 0; // left pointer

        int required = freqMap.size();
        int formed = 0;

        int[] best = {-1, 0, 0}; // length, left, right

        while (i < s.length()) {

            char c = s.charAt(i);
            windowMap.put(c, windowMap.getOrDefault(c, 0) + 1);

            if (freqMap.containsKey(c) &&
                windowMap.get(c).intValue() == freqMap.get(c).intValue()) {
                formed++;
            }

            // try to shrink window
            while (j <= i && formed == required) {

                if (best[0] == -1 || i - j + 1 < best[0]) {
                    best[0] = i - j + 1;
                    best[1] = j;
                    best[2] = i;
                }

                char leftChar = s.charAt(j);
                windowMap.put(leftChar, windowMap.get(leftChar) - 1);

                if (freqMap.containsKey(leftChar) &&
                    windowMap.get(leftChar) < freqMap.get(leftChar)) {
                    formed--;
                }

                j++;
            }

            i++;
        }

        if (best[0] == -1)
        return "";
        else return s.substring(best[1], best[2] + 1);
    }
}
