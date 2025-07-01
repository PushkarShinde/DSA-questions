class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> freq = new HashMap<>();
        for (char c : s.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }
        /**
        PriorityQueue<> is a heap data structure.
        The lambda (a, b) -> freq.get(b) - freq.get(a) sorts characters so that the one with higher frequency comes first.
        Thus, this turns the min-heap into a max-heap based on character frequency.
        */
        PriorityQueue<Character> pq=new PriorityQueue<>((a,b)->freq.get(b)-freq.get(a));
        pq.addAll(freq.keySet()); //This adds all characters (keys from the frequency map) to the priority queue.
        StringBuilder res = new StringBuilder();
        while (!pq.isEmpty()) {
            char c = pq.poll();               // Get the highest frequency character
            int count = freq.get(c);          // Repeat it 'count' times
            for (int i = 0; i < count; i++) {
                res.append(c);
            }
        }
        return res.toString();
    }
}