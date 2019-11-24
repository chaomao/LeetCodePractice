//https://leetcode-cn.com/problems/find-the-duplicate-number/
public class DuplicateNumber {
    public int findDuplicate(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = (left + right + 1) / 2;
            int counter = 0;
            for (int num : nums) {
                if (num < mid) {
                    counter++;
                }
            }

            if (counter >= mid) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        return left;
    }
}
