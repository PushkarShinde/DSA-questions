class Solution {
    public int search(int[] arr, int target){
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target)
                return mid; 
            if (arr[mid] < target)
                left = mid + 1; 
            else
                right = mid - 1; 
        }
        return left;
    }
    public int searchInsert(int[] nums, int target) {
        return search(nums,target);
    }
}