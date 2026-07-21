class TimeMap {

    Map<String, List<String[]>> timeMap;
    public TimeMap() {
       timeMap = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        List<String[]> l= new ArrayList<>();
       if (timeMap.containsKey(key))
       {
            l = timeMap.get(key);
       }
      
       l.add(new String[]{value, String.valueOf(timestamp)});
       timeMap.put(key,l);

    }
    
    public String get(String key, int timestamp) {
        // Edge case, map doesn't contain key
        if (!timeMap.containsKey(key))
        return "";
        
        List<String[]> l = timeMap.get(key);
        int[] search = new int[l.size()];
        int k = 0;

        // Build an array of the timestamps | Already ordered
        for (String[] arr : l)
        {
            search[k++] = Integer.parseInt(arr[1]);
        }

        String result = "";
        if (timestamp < search[0])
        return result;

        // Binary Search
        int left = 0;
        int right = search.length - 1;
        while (left <= right)
        {
            int mid = left + (right - left) / 2;

            // If found, return String at position mid
            if (search[mid] == timestamp)
            return l.get(mid)[0];
            // If less
            else if (search[mid] > timestamp)
            {
            right = mid - 1;
            }
            // Value lower than timestamp, we retrieve the String in case value does not exist in array
            else 
            {
            result = l.get(mid)[0];
            left = mid + 1;
            }
        }
        return result;
    }
}
        