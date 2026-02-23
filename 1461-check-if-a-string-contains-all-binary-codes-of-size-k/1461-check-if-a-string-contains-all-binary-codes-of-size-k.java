class Solution {
    public boolean hasAllCodes(String s, int k){
        int n=s.length();
        if(n<k) return false;
        Set<Integer> set=new TreeSet<>();
        for(int i=0;i<=n-k;i++){
            String str=s.substring(i,i+k);
            int num=Integer.parseInt(str,2);
            set.add(num);
        }
        int num=0;
        for(int i:set){
            // if(num>=(1<<k)) return false;
            if(i!=num) return false;
            num++;
        }
        return num>=(1<<k);
    }
}