class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        int n=asteroids.length;
        Stack<Integer> st=new Stack<>();
        for(int a: asteroids){
            boolean alive=true;
            while(alive && a<0 && !st.isEmpty() && st.peek()>0){
                int top=st.peek();
                if(top<-a){// top asteroid is smaller, it explodes
                    st.pop();
                }else if(top==-a){// both are equal, both explode
                    st.pop();
                    alive=false;
                }else{// top is bigger, current asteroid explodes
                    alive = false;
                }
            }
            if(alive){
                st.push(a);
            }
        }
        int m=st.size();
        int[] res=new int[m];
        for(int i=m-1;i>=0;i--){
            res[i]=st.pop();
        }
        return res;
    }
}