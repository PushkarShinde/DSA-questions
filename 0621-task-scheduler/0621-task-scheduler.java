class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] letter=new int[26];
        for(int i=0;i<tasks.length;i++){
            letter[tasks[i]-'A']++;
        }
        int time=0;
        PriorityQueue<Integer> maxHeap=new PriorityQueue<>((a,b)->b-a);
        for(int i:letter){
            if(i>0) maxHeap.offer(i);
        }

        while(!maxHeap.isEmpty()){
            ArrayList<Integer> list=new ArrayList<>();
            for(int i=1;i<=n+1;i++){
                if(!maxHeap.isEmpty()){
                    int freq=maxHeap.peek();
                    maxHeap.poll();
                    freq--;
                    list.add(freq);
                }
            }
            for(int i:list){
                if(i>0) maxHeap.add(i);
            }

            if(maxHeap.isEmpty()){
                time+=list.size();
            }else{
                time+=n+1;
            }
        }
        return time;
    }
}