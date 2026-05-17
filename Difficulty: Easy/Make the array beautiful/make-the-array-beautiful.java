class Solution {
    List<Integer> makeBeautiful(int[] arr) {
        int n=arr.length;
        Stack<Integer> stack=new Stack<>();
        List<Integer> res=new ArrayList<>();
        
        for(int i=0;i<n;i++){
            int num=arr[i];
            if(stack.isEmpty()){
                stack.push(num);
                continue;
            }
            int top=stack.peek();
            if((top>=0 && num<0) || (top<0 && num>=0)) {
                stack.pop();
                continue;
            }
            stack.push(num);
        }
        
        while(!stack.isEmpty()) res.add(stack.pop());
        Collections.reverse(res);
        return res;
    }
}