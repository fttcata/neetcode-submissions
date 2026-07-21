class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder valid = new StringBuilder();

        for (int i = 0 ; i < s.length(); i++)
        {
            char c = s.charAt(i);

            if ((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z') || (c >= '0' && c <= '9'))
            {
                if (c >= 'a' && c <= 'z')
                {
                c-=32;
                valid.append(c);
                }
                else valid.append(c);
            }
        }

        for (int i = 0 ; i < valid.length() / 2 ; i++)
        {
            if (valid.charAt(i) != valid.charAt(valid.length() - 1 - i))
            return false;
        }
        return true;
    }
}
