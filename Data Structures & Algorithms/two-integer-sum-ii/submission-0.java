class Solution {
    public int[] twoSum(int[] numbers, int target) {
        HashMap<Integer, Integer> m= new HashMap<>();

        for (int i = 0 ; i < numbers.length; i++)
        {
            if (m.containsKey(target-numbers[i]))
            return new int[]{m.get(target-numbers[i]),i+ 1};
            m.put(numbers[i],i + 1);
        }
        return new int[]{0,0};
    }
}
