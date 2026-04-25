class Solution {
    public ArrayList<Integer> reducePairs(int[] arr) {
        int n=arr.length;
        Stack<Integer> stack=new Stack<>();
        for(int cur:arr){
            boolean destroy=false;
            while(!stack.isEmpty() && opposite(stack.peek(), cur)){
                int top=stack.peek();
                int absTop=Math.abs(top);
                int absCur=Math.abs(cur);
                
                if(absTop>absCur){
                    destroy=true;
                    break;
                }else if(absTop<absCur){
                    stack.pop();
                    destroy=false;
                }else{
                    stack.pop();
                    destroy=true;
                    break;
                }
            }
            
            if(!destroy){
                stack.push(cur);
            }
        }
        return new ArrayList<>(stack);
    }
    
    private boolean opposite(int a, int b){
        return (a>0 && b<0) || (a<0 && b>0);
    }
}