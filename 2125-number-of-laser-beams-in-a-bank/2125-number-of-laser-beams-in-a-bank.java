class Solution {
    public int numberOfBeams(String[] bank) {
        int n=bank.length;
        List<Integer> row=new ArrayList<>();
        for(int i=0;i<n;i++){
            int one=0;
            for(char c: bank[i].toCharArray()){
                if(c=='1') one++;
            }
            if(one!=0)row.add(one);
        }
        int res=0;
        for(int i=0;i<row.size()-1;i++){
            int a=row.get(i);
            int b=row.get(i+1);
            res+=(a*b);
        }
        return res;
    }
}