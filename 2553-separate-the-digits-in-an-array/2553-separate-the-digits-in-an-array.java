class Solution {
    public int[] separateDigits(int[] nums) {
        List<Integer> res=new ArrayList<>();
        Stack<Integer> dig=new Stack<>();
        for(int num: nums){
            while(num>0){
                dig.push(num%10);
                num/=10;
            }
            while(!dig.isEmpty()){
                res.add(dig.pop());
            }
        }
        int[] ans=new int[res.size()];
        for(int i=0;i<res.size();i++){
            ans[i]=res.get(i);
        }

        return ans;
    }
}