class Solution {
    public String firstNonRepeating(String s) {
        int n=s.length();
        int[] rep=new int[26];
        StringBuilder sb=new StringBuilder();
        int nonrep=0;
        for(int i=0;i<n;i++){
            char c=s.charAt(i);
            rep[c-'a']++;
            if(rep[s.charAt(nonrep)-'a']==1){
                sb.append(s.charAt(nonrep));
            }else{
                while(nonrep<=i && rep[s.charAt(nonrep)-'a']!=1) nonrep++;
                if(nonrep>i)sb.append('#');
                else sb.append(s.charAt(nonrep));
            }
        }
        return sb.toString();
    }
}