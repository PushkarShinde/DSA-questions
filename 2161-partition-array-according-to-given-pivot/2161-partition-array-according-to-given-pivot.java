class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int n=nums.length;
        List<int[]> before=new ArrayList<>();
        List<int[]> after=new ArrayList<>();
        int fre=0;
        for(int i=0;i<n;i++){
            int num=nums[i];
            if(num==pivot){
                fre++;
            }else if(num<pivot){
                before.add(new int[]{i, num});
            }else{
                after.add(new int[]{i, num});
            }
        }   
        before.sort((x,y)->x[0]-y[0]);
        after.sort((x,y)->x[0]-y[0]);

        int[] res=new int[n];
        int ind=0;
        while(ind<before.size()){
            res[ind]=before.get(ind)[1];
            ind++;
        }

        while(fre>0){
            res[ind]=pivot;
            ind++;
            fre--;
        }
        
        int i=0;
        while(ind<n && i<after.size()){
            res[ind]=after.get(i)[1];
            i++;
            ind++;
        }

        return res;
    }
}