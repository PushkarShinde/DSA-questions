class Solution {
    public String chooseSwap(String s) {
        int n=s.length();
        
        int[] pos=new int[26];
        Arrays.fill(pos, -1);
        
        for(int i=0;i<n;i++){
            char c=s.charAt(i);
            if(pos[c-'a']!=-1) continue;
            pos[c-'a']=i;
        }
        
        char[] res=s.toCharArray();
        
        for(int i=0;i<n;i++){
            int cur=res[i]-'a';
            
            for(int j=0;j<cur;j++){
                if(pos[j]>i){//badme mila h
                    char a=res[i];
                    char b=(char)('a'+j);
                    
                    for(int k=0;k<n;k++){
                        if(res[k]==a){
                            res[k]=b;
                        }else if(res[k]==b){
                            res[k]=a;
                        }
                    }
                    String ans=new String(res);
                    if(ans.compareTo(s)<1) return ans;
                    return s;
                }
            }
        }
        
        return s;
    }
}