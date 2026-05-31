class Solution {
    public boolean asteroidsDestroyed(int mass, int[] ast) {
        Arrays.sort(ast);
        long m=(long)mass;
        for(int a:ast){
            if(m>=a) m+=(long)a;
            else return false;
        }
        return true;
    }
}