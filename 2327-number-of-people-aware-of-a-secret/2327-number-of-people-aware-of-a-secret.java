class Solution {
    public int peopleAwareOfSecret(int n, int delay, int forget) {
        final int mod=1000000007; //1e9+7 is actually a double

        long[] learnedOnday=new long[n+1];//kisko kabh pata chala
        learnedOnday[1]=1;//1 person learns on day 1
        //har ek din simulate karenge
        for(int curday=2;curday<n+1;curday++){
            long newlearner=0;
            for(int pastday=1;pastday<curday;pastday++){
                int daysSinceLearned=curday-pastday;
                if(daysSinceLearned>=delay && daysSinceLearned<forget){
                    newlearner=(newlearner+learnedOnday[pastday])%mod;
                }
            }
            learnedOnday[curday]=newlearner;
        }
        //aise kitne log h jinhone day n pe bhi yaad rakha h
        long totalremember=0;
        for(int day=1;day<=n;day++){
            int daysSincelearned=n-day;
            if(daysSincelearned<forget){
                totalremember=(totalremember+learnedOnday[day])%mod;
            }
        }
        return (int)totalremember;
    }
}