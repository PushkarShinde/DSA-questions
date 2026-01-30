class Solution {
    public void rearrangeQueue(Queue<Integer> q) {
        int n=q.size();
        int[] h1=new int[(n/2)+1];
        int[] h2=new int[n/2];
        int i=0;
        while(i<n/2){
            h1[i]=q.poll();
            i++;
        }
        i=0;
        while(i<n/2){
            h2[i]=q.poll();
            i++;
        }
        int j=0; i=0;
        int ind=0;
        while(ind<n){
            if(ind%2==0){
                q.offer(h1[i]);
                i++;
            }else{
                q.offer(h2[j]);
                j++;
            }
            ind++;
        }
    }
}
