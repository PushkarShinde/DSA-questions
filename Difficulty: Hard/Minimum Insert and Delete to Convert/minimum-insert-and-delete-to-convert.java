class Solution {
    public int minInsAndDel(int[] a, int[] b) {
        int n=a.length, m=b.length;
        
        List<Integer> listA=new ArrayList<>();
        for(int i:a){
            if(Arrays.binarySearch(b,i)>=0) listA.add(i);
        }
        
        int[] tails=new int[listA.size()];
        int lis=0;
        for(int num:listA){
            int left=0;
            int right=lis;
            
            while(left<right){
                int mid=left+((right-left)>>1);
                if(tails[mid]<num){
                    left=mid+1;
                }else{
                    right=mid;
                }
            }
            
            tails[left]=num;
            
            if(left==lis){
                lis++;
            }
        }
        return (n-lis)+(m-lis);
    }
}