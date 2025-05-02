class Solution {
    public String pushDominoes(String dominoes) {
        int n=dominoes.length();
        int[] leftClosestR=new int[n];
        int[] rightClosestL=new int[n];

        int lastR=-1;
        for(int i=0;i<n;i++){
            if(dominoes.charAt(i)=='R'){
                lastR=i;
            }else if(dominoes.charAt(i)=='L'){
                lastR=-1;
            }
            leftClosestR[i]= lastR;
        }
        int lastL=-1;
        for(int i=n-1;i>=0;i--){
            if(dominoes.charAt(i)=='L'){
                lastL=i;
            }else if(dominoes.charAt(i)=='R'){
                lastL=-1;
            }
            rightClosestL[i]= lastL;
        }
        
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < n; i++) {
            char current = dominoes.charAt(i);
            if (current != '.') {
                res.append(current);
            } else {
                int left = leftClosestR[i];
                int right = rightClosestL[i];

                int distR = (left == -1) ? Integer.MAX_VALUE : i - left;
                int distL = (right == -1) ? Integer.MAX_VALUE : right - i;

                if (distR == distL) {
                    res.append('.');
                } else if (distR < distL) {
                    res.append('R');
                } else {
                    res.append('L');
                }
            }
        }

        return res.toString();
    }
}