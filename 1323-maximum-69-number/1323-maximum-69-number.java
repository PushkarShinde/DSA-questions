class Solution {
    public int maximum69Number (int num) {
        int n=Integer.toString(num).length();
        // String res="";
        // int n=in.length();
        // int i=0;
        // for(i=0;i<n;i++){
        //     if(in.charAt(i)=='6'){
        //         res+="9";
        //         break;
        //     }
        //     res+=in.charAt(i);
        // }
        // while(i+1<n){
        //     res+=in.charAt(i);
        //     i++;
        // }
        // return Integer.parseInt(res);
        int[] dig=new int[n];
        int nu=num;
        for(int i=n-1;i>=0;i--){
            dig[i]=nu%10;
            nu/=10;
        }
        int res=0;
        boolean changed=false;
        for(int i=0;i<n;i++){
            if(!changed && dig[i]==6){
                dig[i]=9;
                changed=true;
            }
            res=res*10+dig[i];
        }
        return res;
    }
}