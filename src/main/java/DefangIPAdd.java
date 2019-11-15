//https://leetcode-cn.com/problems/defanging-an-ip-address

public class DefangIPAdd {
    public String defangIPAddr(String address) {
//        return address.replace(".", "[.]");
//        StringBuilder builder = new StringBuilder();
//        for (int i = 0; i < address.length(); i++) {
//            builder.append(address.charAt(i) == '.' ? "[.]" : address.charAt(i));
//        }
//        return builder.toString();

        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < address.length(); i++) {
            buffer.append(address.charAt(i) == '.' ? "[.]" : address.charAt(i));
        }
        return buffer.toString();
    }
}
