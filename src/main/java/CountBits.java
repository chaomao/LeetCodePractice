//https://leetcode-cn.com/problems/counting-bits/
public class CountBits {

    public int[] countBits(int num) {
        int[] result = new int[num + 1];
        result[0] = 0;

        boolean odd = true;
        for (int i = 1; i <= num; i++) {
            if (odd) {
                result[i] = 1 + result[i >> 1];
                odd = false;
            } else {
                result[i] = result[i >> 1];
                odd = true;
            }
        }

        return result;
    }
}
