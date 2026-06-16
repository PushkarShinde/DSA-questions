class Solution {
    public String processStr(String s) {
        StringBuilder res=new StringBuilder();
        for(char c:s.toCharArray()){
            if(c=='*'){
                if(!res.isEmpty()) res.deleteCharAt(res.length()-1);
            }else if(c=='%'){
                res.reverse();
            }else if(c=='#'){
                res.append(res);
            }else {
                res.append(c);
            }
        }
        return res.toString();
    }
}