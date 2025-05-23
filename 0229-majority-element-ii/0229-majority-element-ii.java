class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        int min = n / 3;
        List<Integer> ans = new ArrayList<>();

        Integer c1 = null, c2 = null;
        int count1 = 0, count2 = 0;

        // Step 1: Find potential candidates
        for (int num : nums) {
            if (c1 != null && num == c1) {
                count1++;
            } else if (c2 != null && num == c2) {
                count2++;
            } else if (count1 == 0) {
                c1 = num;
                count1 = 1;
            } else if (count2 == 0) {
                c2 = num;
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }

        // Step 2: Validate the candidates
        count1 = 0;
        count2 = 0;
        for (int num : nums) {
            if (c1 != null && num == c1) count1++;
            if (c2 != null && num == c2) count2++; 
        }

        if (count1 > min) ans.add(c1);
        if (c2 != null && !c2.equals(c1) && count2 > min) ans.add(c2); 

        return ans;
    }
}
