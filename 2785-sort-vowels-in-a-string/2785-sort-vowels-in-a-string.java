class Solution {
    public String sortVowels(String s) {
        PriorityQueue<Character> pq=new PriorityQueue<>();
        char[] vovel=new char[]{'A', 'E', 'I', 'O', 'U', 'a', 'e', 'i', 'o', 'u'};
        StringBuilder res=new StringBuilder();
        int ind=0;
        for(char c: s.toCharArray()){
            if(contains(c,vovel)) pq.offer(c);
        }
        for(char c: s.toCharArray()){
            if(contains(c,vovel)) res.append(pq.poll());
            else res.append(c);
        }
        return res.toString();
    }
    private boolean contains(char c, char[] ch){
        for(char s: ch){
            if(s==c) return true;
        }
        return false;
    }
}