//https://leetcode-cn.com/problems/generate-parentheses/
import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {
    public List<String> generateParenthesis(int pairCount) {
        ArrayList<String> result = new ArrayList<>();
        int left = 0, right = 0;
        backtrace(result, "", pairCount, left, right);
        return result;
    }

    void backtrace(List<String> result, String tmp, int pairCount, int left, int right) {

        if (tmp.length() == 2 * pairCount) {
            result.add(tmp);
            return;
        }

        if (left < pairCount) {
            backtrace(result, tmp + "(", pairCount, left + 1, right);
        }
        if (left > right) {
            backtrace(result, tmp + ")", pairCount, left, right + 1);
        }
    }
}
