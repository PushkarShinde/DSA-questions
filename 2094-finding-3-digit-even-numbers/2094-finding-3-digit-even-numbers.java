class Solution {
    public int[] findEvenNumbers(int[] digits) {
        int n=digits.length;
        int[] map=new int[10];
        ArrayList<Integer> res=new ArrayList<>();
        for(int i=0;i<n;i++){
            map[digits[i]]++;
        }
        for(int i=1;i<10;i++){
            if(map[i]==0) continue;
            map[i]--;
            for(int j=0;j<10;j++){
                if(map[j]==0) continue;
                map[j]--;
                for(int k=0;k<9;k+=2){ // unit dig toh even hi rahega
                    if(map[k]==0) continue;
                    int num=i*100+j*10+k;
                    res.add(num);
                }
                map[j]++;
            }
            map[i]++;
        }
        int m=res.size();
        int[] result=new int[m];
        for(int i=0;i<m;i++){
            result[i]=res.get(i);
        }
        return result;
    }
}