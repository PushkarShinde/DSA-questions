class Fancy {
    List<Long> fancy;
    long add;
    long mult;
    int mod=(int)1e9+7;
    public Fancy() {
        add=0;
        mult=1;
        fancy=new ArrayList<>();
    }
    
    public void append(int val) {//1
        long normalised=(val-add)%mod;
        if(normalised<0) normalised+=mod;
        normalised=normalised*modInverse(mult)%mod;
        fancy.add(normalised);
    }
    
    public void addAll(int inc) {//n
        add=(add+inc)%mod;
    }
    
    public void multAll(int m) {//n
        add=(add*m)%mod;
        mult=(mult*m)%mod;
    }
    
    public int getIndex(int idx) {//1
        if(idx>=fancy.size()) return -1;
        long val=fancy.get(idx);
        return (int)((val*mult+add)%mod);
    }

    private long modInverse(long x){
        return pow(x, mod-2);
    }

    private long pow(long a, long b){
        long res=1;
        while(b>0){
            if((b&1)==1) res=res*a%mod;
            a=a*a%mod;
            b>>=1;
        }
        return res;
    }
}

/**
 * Your Fancy object will be instantiated and called as such:
 * Fancy obj = new Fancy();
 * obj.append(val);
 * obj.addAll(inc);
 * obj.multAll(m);
 * int param_4 = obj.getIndex(idx);
 */