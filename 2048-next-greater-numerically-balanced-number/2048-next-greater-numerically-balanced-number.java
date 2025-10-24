class Solution {
    public int nextBeautifulNumber(int n) {
        int i=n+1;
        while(true){
            if(beauty(i)) return i;
            i++;
        }
    }
    private boolean beauty(int num){
        int n=(int)Math.ceil(Math.log10(num));
        int[] dig=new int[n];
        int i=0;
        while(num>0 && i<n){
            dig[i]=num%10;
            num/=10;
            i++;
        }
        Map<Integer,Integer> map=new HashMap<>();
        for(int j=0;j<n;j++){
            map.put(dig[j], map.getOrDefault(dig[j],0)+1);
        }
        for(int key: map.keySet()){
            if(key!=map.get(key)) return false;
        }
        return true;
    }
}