import java.util.HashMap;

//https://leetcode-cn.com/problems/majority-element/
public class MajorityElement {

    public int majorityElement(int[] nums) {
        int balance = 0;
        int result = -1;

        for (int i : nums) {
            if (balance == 0) result = i;
            if (result == i) {
                balance++;
            } else {
                balance--;
            }
        }
        return result;
    }
}
