class Solution {
    public int minEatingSpeed(int[] piles, int h) {
    int upper = piles[0];
    int lower = 0;
    // Calculate lower and upper bounds
    for (int i = 1; i < piles.length; i++)
    {
        lower += piles[i];
        if (piles[i] > upper)
        upper = piles[i];
    }
    
    lower = (int)Math.ceil(lower/h);
    int min = upper;
    while (lower <= upper)
    {
        long hours = 0;
        int mid = lower + (upper - lower) / 2;
        for (int i = 0 ; i <piles.length; i++)
        {
            hours += Math.ceil((double)piles[i] / mid);
        }
        if (hours <= h)
        {
        upper = mid -1;
        min = mid;
        }
        else lower = mid + 1;
    }
    return min;
    }
}
