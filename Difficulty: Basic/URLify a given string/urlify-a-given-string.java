class Solution {
    String URLify(String s) {
        StringBuilder res=new StringBuilder();
        for(char c:s.toCharArray()){
            if(c==' '){
                res.append("%20");
            }else{
                res.append(c);
            }
        }
        return res.toString();
    }
}