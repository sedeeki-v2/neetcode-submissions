class Solution { // [3,4,5,6,1,2]
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int minimum = nums[0];

        while (left <= right) {
            if (nums[left] < nums[right]) {
                return Math.min(minimum, nums[left]);
            }

            int middle = left + (right - left) / 2;
            minimum = Math.min(minimum, nums[middle]);

            if (nums[middle] >= nums[left]) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }

        return minimum;
    }
}
