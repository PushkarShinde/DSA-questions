class Solution {
    static ArrayList<Integer> res;
    public static ArrayList<Integer> increasingNumbers(int n) {
        res=new ArrayList<>();
        
        if(n>9) return res;
        if(n==1){
            for(int i=0;i<=9;i++) res.add(i);
            return res;
        }
        
        for(int i=1;i<=9;i++){
            solve(res,n, i, i, 1);
        }
        return res;
    }
    private static void solve(ArrayList<Integer> res, int n, int num, int pre, int len){
        if(len==n){
            res.add(num);
            return;
        }
        
        for(int i=pre+1;i<=9;i++){
            int newNum=num*10+i;
            solve(res,n, newNum, i, len+1);
        }
    }
}
