class Solution {
    public int maxTotalValue(int[] value, int[] decay, int m) {
        int n=value.length;
        long mod=(long)1e9+7;

        long l=0, r=(long)1e9;
        long threshold=0;
        while(l<=r){
            long mid=l+((r-l)>>1);
            if(pick(value, decay, m, mid)){
                threshold=mid;
                l=mid+1;
            }else{
                r=mid-1;
            }
        }

        long total=0;
        long used=0;

        //Sum = k x V - D *k*(k-1)/2 // sum of k elements in an AP
        for(int i=0;i<n;i++){
            if(value[i]>threshold){
                long k=(value[i]-(threshold+1))/decay[i]+1;
                used+=k;

                long v=value[i]%mod;
                long d=decay[i]%mod;
                long km=k%mod;

                long totalV=(km*v)%mod;
                long kk=0;
                if(k%2==0){
                    kk=(((k/2)%mod)*((k-1)%mod))%mod;
                }else{
                    kk=((k%mod)*(((k-1)/2)%mod))%mod;
                }

                long totalD=(d*kk)%mod;
                long curSum=(totalV-totalD+mod)%mod;

                total=(total+curSum)%mod;
            }
        }

        long remain=m-used;
        if(remain>0 && threshold>0){
            long score=(remain%mod)*(threshold%mod)%mod;
            total=(total+score)%mod;
        }
        return (int)total;
    }

    private boolean pick(int[] val, int[] dec, int m, long tar){
        long count=0;
        for(int i=0;i<val.length;i++){
            if(val[i]>=tar){
                //n=((an-a)/d)+1
                //value ko target tak niche leke ane me kitne steps lagenge
                count+=((val[i]-tar)/dec[i])+1;
                if(count>=m) return true;
            }
        }
        return count>=m;
    }
}