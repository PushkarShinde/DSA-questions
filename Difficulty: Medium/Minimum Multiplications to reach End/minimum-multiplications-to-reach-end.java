class Solution {
    public int minSteps(int[] arr, int start, int end) {
        int n=arr.length;
        Queue<Integer> q=new LinkedList<>();
        q.offer(start);
        int step=0;
        Set<Integer> set=new HashSet<>();
        
        while(!q.isEmpty()){
            int size=q.size();
            while(size-->0){
                int cur=q.poll();
                if(cur==end){
                    return step;
                }
                
                for(int a:arr){
                    int num=(cur*a)%1000;
                    if(!set.contains(num)){
                        set.add(num);
                        q.offer(num);
                    }
                }
            }
            step++;
        }
        return -1;
    }
}