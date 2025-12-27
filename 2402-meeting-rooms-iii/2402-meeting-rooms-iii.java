class Solution {
    public int mostBooked(int n, int[][] meetings) {
        Arrays.sort(meetings,(a,b)-> Integer.compare(a[0],b[0]));
        int[] count=new int[n];
        PriorityQueue<Integer> freeRoom=new PriorityQueue<>();
        for(int i=0;i<n;i++){
            freeRoom.offer(i);
        }
        PriorityQueue<long[]> busyRoom=new PriorityQueue<>((a,b)->{//[end time,room number]
            if(a[0]!=b[0]) return Long.compare(a[0],b[0]);
            return Long.compare(a[1],b[1]);
        });//isko end time pe sort karenge and room number
        for(int[] m:meetings){
            int start=m[0], end=m[1];
            while(!busyRoom.isEmpty() && busyRoom.peek()[0]<=start){
                long[] room=busyRoom.poll();
                freeRoom.offer((int)room[1]);
            }
            int assignedRoom=0;
            if(!freeRoom.isEmpty()){//free room hai available
                assignedRoom=freeRoom.poll();
                busyRoom.offer(new long[]{end,assignedRoom});
            }else{//free room hi nahi hai toh wait karenge
                long[] earliestRoom=busyRoom.poll();
                long roomEnd=earliestRoom[0];
                assignedRoom=(int)earliestRoom[1];
                long duration=end-start;
                long newEnd=roomEnd+duration;
                busyRoom.offer(new long[]{newEnd,assignedRoom});
            }
            count[assignedRoom]++;
        }
        int maxAssigned=0;
        int maxRoom=0;
        for(int i=0;i<n;i++){
            if(maxAssigned<count[i]){
                maxAssigned=count[i];
                maxRoom=i;
            }
        }
        return maxRoom;
    }
}