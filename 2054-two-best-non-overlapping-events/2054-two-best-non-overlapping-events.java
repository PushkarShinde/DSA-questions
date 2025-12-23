class Solution {
    public int maxTwoEvents(int[][] events) {
        int n=events.length;
        Arrays.sort(events, (a,b)-> Integer.compare(a[0],b[0]));
        int[] suffix=new int[n];
        suffix[n-1]=events[n-1][2];
        for(int i=n-2;i>=0;i--){
            suffix[i]=Math.max(suffix[i+1], events[i][2]);
        }

        int maxRes=0;
        for(int i=0;i<n;i++){
            int y=events[i][1], val=events[i][2];
            maxRes=Math.max(maxRes, val);
            int left=i+1, right=n-1;
            while(left<=right){
                int mid=left+(right-left)/2;
                if(events[mid][0]<=y){
                    left=mid+1;
                }else{
                    right=mid-1;
                }
            }
            // for(int j=left;j<n;j++){
            //     maxRes=Math.max(maxRes, val+events[j][2]); // ye basically O(n^2) hi kar raha hai
            // }
            if(left<n){
                maxRes=Math.max(maxRes, val+suffix[left]);
            }
        }
        return maxRes;
    }
}