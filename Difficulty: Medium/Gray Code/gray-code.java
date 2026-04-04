class Solution {
    public ArrayList<String> graycode(int n) {
        ArrayList<String> res=new ArrayList<>();
        if(n==1){
            res.add("0");
            res.add("1");
            return res;
        }
        
        int len=(1<<n);
        String[] str=new String[len];
        str[0]="00";
        str[1]="01";
        str[2]="11";
        str[3]="10";
        
        if(n==2){
            for(int i=0;i<len;i++){
                res.add(str[i]);
            }
            return res;
        }
        
        int i=2;
        while(i<n){
            int ind=1<<i;
            int lastInd=1<<(i+1);
            int rev=1;
            for(int j=ind;j<lastInd;j++){
                str[j]=str[ind-rev];
                rev++;
            }
            
            for(int j=0;j<lastInd;j++){
                if(j<lastInd/2) str[j]="0"+str[j];
                else str[j]="1"+str[j];
            }
            
            i++;
        }
        
        for(String s:str){
            res.add(s);
        }
        
        return res;
    }
}