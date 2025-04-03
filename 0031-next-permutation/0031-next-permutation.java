class Solution {
    private void swap(int[] nums, int a, int b){
        int temp=nums[a];
        nums[a]=nums[b];
        nums[b]=temp;
    }
    private void reverse(int[] nums, int l, int r){
        if(l==r) return;
        while(l<r){
            swap(nums, l,r);
            l++; r--;
        }
    }
    public void nextPermutation(int[] nums) {
        /* BRUTE FORCE APROACH 
        TC- O(N! x N)   SC- O(N!)
        1. Recurrsively generate all the posible permutations
        2. linear search through the permutations and return the permutations just after it.
        3. return the first permutations if the given one is the last.  
        */

        /* BETTER APPROACH
        STL in C++... 
        next_permutation(nums.begin(), nums.end());
         */

        // OPTIMAL APPROACH
        // pehla innstance dekhenge jabh nums[i]<nums[i+1] hua
        // well need to replace that with the next greater num
        int n=nums.length;
        int ind=-1;
        for(int i=n-2;i>=0;i--){
            if(nums[i]<nums[i+1]){
                ind=i;
                break;
            }
        }
        if(ind==-1) {
            Arrays.sort(nums);
            return;
        }
        // now we'll look for a numberr that is just greater that nums[ind], with index > ind
        for(int i=n-1;i>=ind;i--){
            if(nums[ind]<nums[i]){
                swap(nums, ind, i);
                break;
            }
        }
        reverse(nums, ind+1, n-1);
    }
}


















