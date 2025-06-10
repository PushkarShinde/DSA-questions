class Solution {
    public int maxDifference(String s) {
        HashMap<Character, Integer> map=new HashMap<>();
        int maxOdd=Integer.MIN_VALUE;
        int minEven=Integer.MAX_VALUE;
        for(char c:s.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }
        for(int freq: map.values()){
            if(freq%2==0){
                minEven=Math.min(minEven,freq);
            }else{
                maxOdd=Math.max(maxOdd,freq);
            }
        }
        // SSecurity check, just in case. Hehe!
        // if(minEven==Integer.MAX_VALUE || maxOdd==Integer.MIN_VALUE){
        //     return -1;
        // } 
        return maxOdd-minEven;
    }
}