//https://leetcode-cn.com/problems/combination-sum/

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        ArrayList<List<Integer>> result = new ArrayList<>();
        if (target == 0) return result;
        Stack<Integer> stack = new Stack<>();
        backtrace(result, candidates, target, stack, 0);
        return result;
    }

    private void backtrace(ArrayList<List<Integer>> result, int[] candidates, int target, Stack<Integer> stack, int index) {
        if (target < 0) return;
        if (target == 0) {
            result.add(new ArrayList<>(stack));
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            if (target >= candidates[i]) {
                stack.push(candidates[i]);
                backtrace(result, candidates, target - candidates[i], stack, i);
                stack.pop();
            }
        }

    }
}
