//https://leetcode-cn.com/problems/subsets/

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        backtrack(0, nums, results, new Stack<>());
        return results;
    }

    private void backtrack(int start, int[] nums, List<List<Integer>> result, Stack<Integer> stack) {
        result.add(new ArrayList<>(stack));

        for (int j = start; j < nums.length; j++) {
            stack.add(nums[j]);
            backtrack(j + 1, nums, result, stack);
            stack.pop();
        }
    }

}
