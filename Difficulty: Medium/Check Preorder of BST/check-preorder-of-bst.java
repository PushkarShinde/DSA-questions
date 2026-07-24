class Solution {
    public boolean canRepresentBST(List<Integer> arr) {
        Stack<Integer> stack=new Stack<>();
        int lowerBound=Integer.MIN_VALUE;
        
        for(int i:arr){
            if(lowerBound>i) return false;
            
            while(!stack.isEmpty() && stack.peek()<i){
                lowerBound=Math.max(lowerBound,stack.pop());
            }
            
            stack.add(i);
        }
        
        return true;
    }
}