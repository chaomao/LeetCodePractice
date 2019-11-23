//https://leetcode-cn.com/problems/product-of-array-except-self/
public class ProductOfArray {
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        int k = 1;
        for(int i = 0; i < res.length; i++){
            res[i] = k;
            k = k * nums[i]; // 此时数组存储的是除去当前元素左边的元素乘积
        }
        k = 1;
        for(int i = res.length - 1; i >= 0; i--){
            res[i] *= k; // k为该数右边的乘积。
            k *= nums[i]; // 此时数组等于左边的 * 该数右边的。
        }
        return res;
    }



    private int[] solution1(int[] nums) {
        int[] result = new int[nums.length];

        int prod = 1;
        for (int i = 0; i < result.length; i++) {
            prod *= nums[i];
        }

        for (int i = 0; i < result.length; i++) {
            result[i] = prod / nums[i];
        }
        return result;
    }
}
