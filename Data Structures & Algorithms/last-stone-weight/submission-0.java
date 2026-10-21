class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int num : stones)
        {
            pq.add(num);
        }

        while (pq.size() > 1)
        {
            int x = pq.poll();
            int y = pq.poll();

            if (x == y)
            continue;
            else if (x > y)
            pq.add(x-y);

        }

        if (pq.size() == 1)
        return pq.peek();

        return 0;
    }
}
