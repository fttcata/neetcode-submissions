class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> m = new HashMap<>();

        List<List<String>> lst = new ArrayList<>();
        
        for (int i = 0 ; i<strs.length; i++)
        {
            char[] c = strs[i].toCharArray();
            Arrays.sort(c);
            String sorted = new String(c);
            if (m.containsKey(sorted))
            {
                List<String> s = m.get(sorted);
                s.add(strs[i]);
            }
            else
            {
            List<String> s = new ArrayList<>();
            s.add(strs[i]);
            m.put(sorted,s);
            }
        }

        lst.addAll(m.values());
        return lst;




    }
}
