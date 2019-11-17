//https://leetcode-cn.com/problems/permutations/
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Permutation {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        if (nums.length == 0) return results;
        boolean[] used = new boolean[nums.length];

        generatePermutation(nums, results, 0, used, new Stack<>());
        return results;
    }

    private void generatePermutation(int[] nums, List<List<Integer>> results, int level, boolean[] used, Stack<Integer> stack) {
        if(level == nums.length) {
            results.add(new ArrayList<>(stack));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;
            stack.push(nums[i]);
            used[i] = true;

            generatePermutation(nums, results, level + 1, used, stack);
            used[i] = false;
            stack.pop();
        }
    }
}
