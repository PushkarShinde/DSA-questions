class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> res=new ArrayList<>();
        for(int i=1;i<=9;i++){
            int num=0;
            for(int j=i;j<=9;j++){
                num=num*10+j;
                if(num<low) continue;
                if(num>high) break;

                res.add(num);
            }
        }
        Collections.sort(res);
        
        return res;
    }
}