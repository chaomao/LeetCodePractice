//https://leetcode-cn.com/problems/subsets/
import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Subsets {
//    public List<List<Integer>> subsets(int[] nums) {
//        List<List<Integer>> results = new ArrayList<>();
//        backtrack(0, nums, results, new Stack<>());
//        return results;
//    }
//
//    private void backtrack(int start, int[] nums, List<List<Integer>> result, Stack<Integer> stack) {
//        result.add(generateListFromStack(stack));
//        for (int j = start; j < nums.length; j++) {
//            stack.add(nums[j]);
//            backtrack(j + 1, nums, result, stack);
//            stack.pop();
//        }
//    }
//
//    List<Integer> generateListFromStack(Stack<Integer> stack) {
//        ArrayList<Integer> result = new ArrayList<>();
//        result.addAll(stack);
//        return result;
//    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        results.add(new ArrayList<>());
        for (int i : nums) {
            int size = results.size();
            for (int j = 0; j < size; j++) {
                ArrayList<Integer> newArray = new ArrayList<>(results.get(j));
                newArray.add(i);
                results.add(newArray);
            }
        }
        return results;
    }


}
