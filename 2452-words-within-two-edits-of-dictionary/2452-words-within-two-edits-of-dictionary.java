class Solution {
    public List<String> twoEditWords(String[] queries, String[] dictionary) {
        List<String> res=new ArrayList<>();
        for(String q:queries){
            boolean added=false;
            for(String d:dictionary){
                if(added) break;
                int n=d.length();
                // int m=q.length();
                // if(n!=m) continue;

                int dif=0;
                for(int i=0;i<n;i++){
                    if(d.charAt(i)!=q.charAt(i)) dif++;
                }

                if(dif<=2) {    
                    res.add(q);
                    added=true;
                }
            } 
        }
        return res;
    }
}