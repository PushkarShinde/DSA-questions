class Solution {
    public int countCollisions(String directions) {
        int n=directions.length();
        // boolean[] stop=new boolean[n];
        int i=0;
        while(i<n){
            char c=directions.charAt(i);
            if(c!='L'){
                break;
            }
            i++;
        }
        int j=n-1;
        while(j>=0){
            char c=directions.charAt(j);
            if(c!='R'){
                break;
            }
            j--;
        }
        if(i>j) return 0;
        int res=0;
        int stat=0;
        // Stack<Character> stack=new Stack<>();
        for(int k=i;k<=j;k++){
            char c=directions.charAt(k);
            // if(!stack.isEmpty()){
            //     char top=stack.peek();
            //     if(top=='R'){
            //         if(c=='L'){
            //             res+=2;
            //         }else if(top=='S'){
            //             res++;
            //         }

            //     }
            // }
            // stack.add(c);
            if(c=='S') stat++;
        }
        res+=(j-i+1)-stat;
        return res;
    }
}