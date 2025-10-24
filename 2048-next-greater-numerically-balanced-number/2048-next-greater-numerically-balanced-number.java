class Solution {
    public int nextBeautifulNumber(int n) { //we can also create permutations upto 7 digits and then check
        int i=n+1;
        while(true){
            if(beauty(i)) return i;
            i++;
        }
    }
    private boolean beauty(int num){
        int n=(int)Math.log10(num) + 1;
        int[] dig=new int[n];
        int i=0;
        while(num>0 && i<n){
            dig[i]=num%10;
            num/=10;
            i++;
        }
        // Map<Integer,Integer> map=new HashMap<>();
        int[] map=new int[10];
        for(int j=0;j<n;j++){
            // map.put(dig[j], map.getOrDefault(dig[j],0)+1);
            map[dig[j]]++;
        }
        for(int key=0;key<10;key++){
            if(map[key]>0 && key!=map[key]) return false;
        }
        return true;
    }
}