class Solution {
    public long minCost(int[] basket1, int[] basket2) {
        int n = basket1.length;
        Map<Integer, Integer> count = new HashMap<>();

        for (int x : basket1) count.put(x, count.getOrDefault(x, 0) + 1);
        for (int x : basket2) count.put(x, count.getOrDefault(x, 0) - 1);
        List<Integer> toSwap = new ArrayList<>();
        int minElement = Integer.MAX_VALUE;

        for (int x : count.keySet()) {
            int diff = count.get(x);
            if (diff % 2 != 0) return -1; // Not possible
            int freq = Math.abs(diff) / 2;
            for (int i = 0; i < freq; i++) toSwap.add(x);
            minElement = Math.min(minElement, x);
        }

        Collections.sort(toSwap);

        long cost = 0;
        int half = toSwap.size() / 2;
        for (int i = 0; i < half; i++) {
            cost += Math.min(toSwap.get(i), 2 * minElement);
        }

        return cost;
    }
}