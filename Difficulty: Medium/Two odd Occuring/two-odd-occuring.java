class Solution {
    ArrayList<Integer> twoOddNum(int[] arr) {
        int xor=0;
        for(int i:arr){
            xor^=i;        
        }
        
        int rightMostBit=(xor & -xor);
        
        int x=0, y=0;
        for(int i:arr){
            if((i & rightMostBit)!=0){
                x^=i;
            }else{
                y^=i;
            }
        }
        ArrayList<Integer> ans=new ArrayList<>();
        if(x>y){
            ans.add(x);
            ans.add(y);
        }else{
            ans.add(y);
            ans.add(x);
        }
        
        return ans;
    }
}
