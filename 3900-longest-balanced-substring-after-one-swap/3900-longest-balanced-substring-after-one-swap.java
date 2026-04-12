class Solution {
    public int longestBalanced(String s) {
        int n=s.length();
        int[] o=new int[n], z=new int[n], dif=new int[n];
        int one=0, zero=0;
        int totalOne=0;
        for(int i=0;i<n;i++){

            char c=s.charAt(i);
            if(c=='1') one++;
            else zero++;
            o[i]=one;
            z[i]=zero;
            dif[i]=one-zero;
        }

        int maxlen=0;
        Map<Integer, Integer> map=new HashMap<>(), map0=new HashMap<>(), map1=new HashMap<>();
        map.put(0,-1);
        int sum=0;
        for(int i=0;i<n;i++){
            int pre=dif[i];
            //balanced mil gaya
            if(map.containsKey(pre)) maxlen=Math.max(maxlen, i-map.get(pre));

            //unbalanced hai but one swap needed
            if(map.containsKey(pre+2)){//2 extra ones
                int j=map.get(pre+2);
                int subs=o[i]-(j>=0?o[j]:0);//iss sub me itne ones hai
                
                if(one>subs){//bahar bhi kuch ones hai
                    maxlen=Math.max(maxlen, i-j);
                }else if(map1.containsKey(pre+2)){
                    maxlen=Math.max(maxlen, i-map1.get(pre+2));
                }
            }
            if(map.containsKey(pre-2)){//2 extra ones
                int j=map.get(pre-2);
                int subs=z[i]-(j>=0?z[j]:0);//iss sub me itne ones hai

                if(zero>subs){//bahar bhi kuch ones hai
                    maxlen=Math.max(maxlen, i-j);
                }else if(map0.containsKey(pre-2)){
                    maxlen=Math.max(maxlen, i-map0.get(pre-2));
                }
            }
            map.putIfAbsent(pre, i);
            if(z[i]>0) map0.putIfAbsent(pre,i);
            if(o[i]>0) map1.putIfAbsent(pre,i);
        }
        return maxlen;
    }
}