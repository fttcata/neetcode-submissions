class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        // if totalGas - totalCost < 0, it is impossible to traverse
        // We start from the station with the max Gas - Cost

        int result = 0 ;
        int totalGas = 0;
        int totalCost = 0;
        int minSum = Integer.MAX_VALUE;

        for (int i = 0 ; i < cost.length; i++)
        {
            // Computing totalGas and totalCost
            totalGas += gas[i];
            totalCost += cost[i];
            // Finding the index with the most remaining starting gas
            if (totalGas - totalCost <= minSum)
            {
                minSum = totalGas - totalCost;
                if (i == gas.length - 1)
                result = 0;
                else result = i + 1;
            }
        }

        // If cost is higher than possible gas, then its impossible to traverse
        if (totalGas - totalCost < 0)
        return -1;
        
        return result;
    }
}
