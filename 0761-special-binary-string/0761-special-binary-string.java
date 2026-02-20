class Solution {
    public String makeLargestSpecial(String s) {
        return solve(s);
    }
    private String solve(String s){
        List<String> res=new ArrayList<>();
        int n=s.length();
        int start=0;
        int sum=0;
        for(int i=0;i<n;i++){
            sum+=(s.charAt(i)=='1')?1:-1;
            if(sum==0){
                String inner=s.substring(start+1,i);
                res.add("1"+solve(inner)+"0");
                start=i+1;
            }
        }
        Collections.sort(res, Collections.reverseOrder());//sabhse bada pehle
        StringBuilder ans=new StringBuilder();
        for(String r:res){
            ans.append(r);
        }
        return ans.toString();
    }
}