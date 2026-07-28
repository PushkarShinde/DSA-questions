class Solution {
    public String smallestPalindrome(String s) {
        int n=s.length();
        if(n<=3) return s;

        PriorityQueue<Character> pq=new PriorityQueue<>((x,y)->x-y);
        for(int i=0;i<n/2;i++){
            char c=s.charAt(i);
            pq.offer(c);
        }

        char[] ch=s.toCharArray();

        for(int i=0;i<n/2;i++){
            ch[i]=pq.poll();
            ch[n-i-1]=ch[i];
        }

        return new String(ch);
    }
}