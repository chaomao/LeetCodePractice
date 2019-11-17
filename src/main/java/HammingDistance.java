//https://leetcode-cn.com/problems/hamming-distance/
public class HammingDistance {
    public int hammingDistance(int x, int y) {
        if (x == y) return 0;
        return Integer.bitCount(x ^ y);

//        int count = 0;
//        int tmp = x ^ y;
//        while (tmp != 0) {
//            if ((tmp & 1) == 1) count++;
//            tmp = tmp >> 1;
//        }
//
//        return count;
    }
}
