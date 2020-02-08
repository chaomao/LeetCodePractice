//https://leetcode-cn.com/problems/decode-ways

public class ExplainNumber {
    public int explainNumber(String target) {
        if (target.charAt(0) == '0') return 0;

        int[] result = new int[target.length()];
        result[0] = 1;

        if (target.length() > 1) {
            if (target.charAt(1) == '0') {
                if (Integer.parseInt(target.substring(0, 2)) <= 26 && Integer.parseInt(target.substring(0, 2)) > 0)
                    result[1] = result[0];
                else
                    return 0;
            } else {
                if (Integer.parseInt(target.substring(0, 2)) <= 26)
                    result[1] = 2;
                else
                    result[1] = 1;
            }
        } else {
            return 1;
        }

        for (int i = 2; i < target.length(); i++) {
            if (target.charAt(i) == '0') {
                if (target.charAt(i - 1) == '0') {
                    return 0;
                } else {
                    if (Integer.parseInt(target.substring(i - 1, i + 1)) <= 26) {
                        result[i] = result[i - 2];
                    } else {
                        return 0;
                    }
                }
            } else {
                if (target.charAt(i - 1) == '0') {
                    result[i] = result[i - 1];
                } else {
                    if (Integer.parseInt(target.substring(i - 1, i + 1)) <= 26) {
                        result[i] = result[i - 1] + result[i - 2];
                    } else {
                        result[i] = result[i - 1];
                    }
                }
            }
        }
        return result[result.length - 1];
    }

}
