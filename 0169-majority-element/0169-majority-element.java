class Solution {
    public int majorityElement(int[] nums) {
        /* MOST OPTIMAL
        Boyre-Moore Voting Algorithm 
        Agar majority pe count increase kare aur bakiyo pe decrease, toh count will always be positive!
        */
        int ele=nums[0]; // suppose pehla element majority hoga
        int count=0;
        int n=nums.length;
        for(int i=0;i<n;i++){
            if(count==0) ele=nums[i]; // agar count 0 ho gaya toh matlab existing element majority nahi tha, now change it
            if(ele==nums[i]) count++;
            else count--;
        }
        return ele;
    }
}