class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        // Array that combines both position and speed
        int[][] combined = new int[position.length][2];
        
        // Stack that tracks the speed of the fleet
        Stack<Double> s = new Stack<>();

        // Merge the 2 arrays
        for (int i = 0 ; i < position.length; i++)
        {
            combined[i][0] = position[i];
            combined[i][1] = speed[i];
        }

        // Sort the array in descending order
        Arrays.sort(combined, (a,b) -> Integer.compare(b[0],a[0]));

        for (int[] p : combined)
        {
            // Hours needed = (target - position) / speed;
            double hour = (double)(target - p[0]) / p[1];
            if (!s.isEmpty() && hour <= s.peek())
            continue;
            // Push hour onto stack
            s.push(hour);
            
        }

        return s.size();

    }
}
