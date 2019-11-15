//https://leetcode-cn.com/problems/split-a-string-in-balanced-strings
import java.util.Stack;

class BalancedStringSplit {
    public int balancedStringSplit(String s) {
        int balance = 0, result = 0;
        Stack<Character> stack = new Stack<Character>();
//        for (int i = 0; i < s.length(); i++) {
//            if (s.charAt(i) == 'R') {
//                balance++;
//            } else {
//                balance--;
//            }
//            if (balance == 0) result++;
//        }
        for (char c : s.toCharArray()) {
            if(stack.empty()) {
                stack.push(c);
            } else{
                if (stack.peek() != c){
                    stack.pop();
                    if (stack.empty()) result++;
                }
                else{
                    stack.push(c);
                }
            }
//            if (c == 'R') {
//                balance++;
//            } else {
//                balance--;
//            }
//            if(balance == 0) result++;
        }
        return result;
    }
}
