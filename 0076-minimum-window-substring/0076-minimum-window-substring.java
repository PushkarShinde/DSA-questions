class Solution {
    public String minWindow(String s, String t) {
        int m=s.length();
        int n=t.length();
        //Could you find an algorithm that runs in O(m + n) time?
        HashMap<Character, Integer> map=new HashMap<>();
        for(int i=0;i<n;i++){
            char ch=t.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        int uniqueCharCount=map.size();
        int l=0;
        int r=0;
        int minlen=Integer.MAX_VALUE;
        int start=-1; 
        while(r<m && l<=r){
            // expansion phase
            char ch=s.charAt(r);
            if(map.containsKey(ch)){
                map.put(ch,map.get(ch)-1);
                if(map.get(ch)==0){
                    uniqueCharCount--;
                }
            }
            // shrinking phase
            while(uniqueCharCount==0){
                int len=r-l+1;
                if(len<minlen){
                    minlen=len;
                    start=l;
                }
                ch=s.charAt(l);
                if(map.containsKey(ch)){
                    map.put(ch,map.get(ch)+1);
                    if(map.get(ch)>0){
                        uniqueCharCount++;
                    }
                }
                l++;
            }
            r++;
        }
        return (start==-1)?"":s.substring(start,start+minlen);
    }
}