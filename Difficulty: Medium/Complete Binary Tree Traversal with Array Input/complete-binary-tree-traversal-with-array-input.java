class Solution {
    public ArrayList<ArrayList<Integer>> levelSort(int[] arr) {
        Queue<int[]> q=new ArrayDeque<>();
        q.offer(new int[]{arr[0],0});
        int n=arr.length;
        ArrayList<ArrayList<Integer>> res=new ArrayList<>();
        
        while(!q.isEmpty()){
            int size=q.size();
            ArrayList<Integer> list=new ArrayList<>();
            while(size-->0){
                int[] cur=q.poll();
                int val=cur[0];
                int ind=cur[1];
                list.add(val);
                
                if(ind*2+1<n){
                    int left=arr[ind*2+1];
                    q.offer(new int[]{left,ind*2+1});
                }
                if(ind*2+2<n){
                    int right=arr[ind*2+2];
                    q.offer(new int[]{right, ind*2+2});
                }
            }
            Collections.sort(list);
            
            res.add(list);
        }
        
        return res;
    }
}