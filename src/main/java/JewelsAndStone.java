import java.util.HashMap;

//https://leetcode-cn.com/problems/jewels-and-stones/
class JewelsAndStone {
    public int numJewelsInStones(String J, String S) {
//        int result = 0;
//        for (int i = 0; i < S.length(); i++) {
//            char stone = S.charAt(i);
//            if (J.indexOf(stone) != -1) {
//                result++;
//            }
//        }
//        return result;

        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < S.length(); i++) {
            char key = S.charAt(i);
            if (map.containsKey(key)){
                map.put(key, map.get(key) + 1);
            }else {
                map.put(S.charAt(i), 1);
            }
        }
        int result = 0;
        for (int i = 0; i < J.length(); i++) {
            result += map.getOrDefault(J.charAt(i), 0);
        }
        return result;
    }
}
