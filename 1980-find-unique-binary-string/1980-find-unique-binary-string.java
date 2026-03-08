class Solution {
    public String findDifferentBinaryString(String[] nums) {
        int n=nums[0].length();
        Set<Integer> numbers=new HashSet<>();
        for(String s: nums){
            numbers.add(Integer.parseInt(s,2));
        }
        String res="";
        for(int i=0;i<(1<<n);i++){
            if(!numbers.contains(i)){
                String cur=Integer.toBinaryString(i);
                int m=cur.length();
                if(m>0) res="0".repeat(n-m)+cur;
                break;
            }
        }
        return res;
    }
}