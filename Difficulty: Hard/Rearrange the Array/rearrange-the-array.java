class Solution {
    private long mod=(long)1e9+7;
    int minOperations(int[] b) {
        int n=b.length;
        boolean[] vis=new boolean[n];
        Map<Integer, Integer> map=new HashMap<>();
        
        for(int i=0;i<n;i++){
            if(!vis[i]){
                int cur=i;
                int len=0;
                
                while(!vis[cur]){
                    vis[cur]=true;
                    cur=b[cur]-1;
                    len++;
                }
                
                if(len>1){
                    factorize(len,map);
                }
            }
        }
        
        long res=1;
        if(map.isEmpty()) return 1;//sabh apni jagah hi hai
        
        for(int key: map.keySet()){
            int p=map.get(key);
            
            res=(res*power(key,p))%mod;
        }
        
        return (int)res;
    }
    
    private void factorize(int len, Map<Integer, Integer> map){
        for(int i=2;i*i<=len;i++){
            if(len%i==0){
                int count=0;
                while(len%i==0){
                    count++;
                    len/=i;
                }
                map.put(i,Math.max(map.getOrDefault(i,0), count));
            }
        }
        
        if(len>1){
            map.put(len,Math.max(map.getOrDefault(len,0), 1));
        }
    }
    
    private long power(long a, long b){
        long res=1;
        while(b>0){
            if((b&1)==1) res=(res*a)%mod;
            a=(a*a)%mod;
            b>>=1;
        }
        return res;
    }
};