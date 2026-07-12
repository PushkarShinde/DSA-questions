class Bank {
    long[] balance;
    int n;
    public Bank(long[] balance) {
        this.balance=balance;
        this.n=balance.length;
    }
    
    public boolean transfer(int a1, int a2, long money) {
        if(a1<=n && a2<=n && balance[a1-1]>=money){
            balance[a1-1]-=money;
            balance[a2-1]+=money;
            return true;
        }
        return false;
    }
    
    public boolean deposit(int a, long money) {
        if(a<=n){
            balance[a-1]+=money;
            return true;
        }
        return false;
    }
    
    public boolean withdraw(int a, long money) {
        if(a<=n && balance[a-1]>=money) {
            balance[a-1]-=money;
            return true;
        }
        return false;
    }
}

/**
 * Your Bank object will be instantiated and called as such:
 * Bank obj = new Bank(balance);
 * boolean param_1 = obj.transfer(account1,account2,money);
 * boolean param_2 = obj.deposit(account,money);
 * boolean param_3 = obj.withdraw(account,money);
 */