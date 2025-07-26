class Solution {
    public String makeFancyString(String s) {
        int n=s.length();
        if(n<3) return s;
        char pre1=s.charAt(0);
        char pre2=s.charAt(1);
        StringBuilder res=new StringBuilder();
        res.append(pre1);
        res.append(pre2);
        for(int i=2;i<n;i++){
            if(s.charAt(i)==pre2 && pre2==pre1){
                continue;
            }else{
                res.append(s.charAt(i));
            }
            pre1=pre2;
            pre2=s.charAt(i);
        }
        return res.toString();
    }
}