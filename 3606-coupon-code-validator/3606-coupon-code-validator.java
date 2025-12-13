class Solution {
    public List<String> validateCoupons(String[] code, String[] businessLine, boolean[] isActive) {
        int n=code.length;
        List<String> res=new ArrayList<>();
        List<String[]> sorted=new ArrayList<>(); 
        for(int i=0;i<n;i++){
            String c=code[i];
            String bl=businessLine[i];
            boolean active=isActive[i];
            if(c==null || !c.matches("\\w+")){
                continue;
            }
            if(!(bl.equals("electronics") || bl.equals("grocery") || bl.equals("pharmacy") || bl.equals("restaurant"))){
                continue;
            }
            if(!active){
                continue;
            }
            sorted.add(new String[]{c,bl});
        }
        sorted.sort((a,b)->{
            if(a[1].equals(b[1])){
                return a[0].compareTo(b[0]);
            }
            return a[1].compareTo(b[1]);
        });
        for(String[] s: sorted){
            res.add(s[0]);
        }
        return res;
    }
}