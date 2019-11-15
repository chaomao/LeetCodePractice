//https://leetcode-cn.com/problems/guess-numbers/
class GuessNumber {

    public int game(int[] guess, int[] answer) {
        int result = 0;
        if (guess[0] == answer[0]) {
            result++;
        }
        if (guess[1] == answer[1]) {
            result++;
        }
        if (guess[2] == answer[2]) {
            result++;
        }
        return result;
    }
}
