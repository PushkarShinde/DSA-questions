class Solution {
    public String[] divideString(String s, int k, char fill) {
        int n=s.length();
        // how many groups we need
        int group=(n+k-1)/k; // equivalent to ciel of n/k

        int length=group*k; // Pad the string if it's not divisible by k
        StringBuilder str=new StringBuilder(s);
        while(str.length()<length){
            str.append(fill);
        }

        // split the padded string into the group of size k
        String[] res=new String[group];
        for(int i=0;i<group;i++){
            res[i]=str.substring(i*k,(i+1)*k);
        }
        return res;
    }
}