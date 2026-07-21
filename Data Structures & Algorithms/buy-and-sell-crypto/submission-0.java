class Solution {
    public int maxProfit(int[] prices) {
        int curr = prices[0];
        int j = 1;

        int maxProf = 0;
        while (j < prices.length)
        {
            if (prices[j] < curr)
            curr = prices[j];

            if (prices[j] - curr > maxProf)
            maxProf = prices[j] - curr;

            j++;
        }

        return maxProf;
    }
}
