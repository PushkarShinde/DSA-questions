class Solution {
    public int smallestUniqueSubarray(int[] nums) {
        int n=nums.length;
        int l=1, r=n;
        int res=n;
        while(l<=r){
            int mid=l+(r-l)/2;
            if(valid(nums, mid)){
                r=mid-1;
                res=mid;
            }else{
                l=mid+1;
            }
        } 
        return res;
    }

    private long mod1=(int)1e9+7;
    private long mod2=998_244_353L;
    private long b1=131L;
    private long b2=137L;

    private boolean valid(int[] a, int len){
        int n=a.length;
        
        long pow1=1, pow2=1;
        for(int i=0;i<len;i++){
            pow1=pow1*b1%mod1;
            pow2=pow2*b2%mod2;
        }

        long h1=0, h2=0;
        for(int i=0;i<len;i++){
            h1=(h1*b1+a[i])%mod1;
            h2=(h2*b2+a[i])%mod2;
        }

        // Pack two hashes into one Long to avoid collision
        Map<Long, Integer> fre=new HashMap<>();
        long key=h1*mod2+h2;
        fre.merge(key,1,Integer::sum);

        for(int i=1;i<n-len+1;i++){
            h1=(h1*b1-a[i-1]*pow1%mod1 + a[i+len-1]+2*mod1)%mod1;
            h2=(h2*b2-a[i-1]*pow2%mod2 + a[i+len-1]+2*mod2)%mod2;

            key=h1*mod2+h2;
            fre.merge(key,1,Integer::sum);
        }

        for(int count: fre.values()){
            if(count==1) return true;
        }

        return false;
    }
}