//https://leetcode-cn.com/problems/sum-of-square-numbers/
class JudgeSquareSum {
    boolean judgeSquareSum(int c) {
//        for (int i = 0; i <= (int) Math.sqrt(c); i++) {
//            int left = c - i * i;
//            int leftSqrt =  (int) Math.sqrt(left);
//            if (leftSqrt * leftSqrt == left) {
//                return true;
//            }
//        }
//        return false;
        int i = 0, j = (int) Math.sqrt(c);
        while (i <= j) {
            int sum = i * i + j * j;
            if (sum == c) {
                return true;
            } else if (sum > c) {
                j--;
            } else {
                i++;
            }
        }
        return false;
    }
}
