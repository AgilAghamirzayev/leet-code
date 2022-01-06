package algorithms.easy;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"flower", "flow", "floight"}));
    }

    public static String longestCommonPrefix(String[] strs) {
        int length = 200;
        StringBuilder sb = new StringBuilder();

        for (String str : strs) {
            if (length > str.length()) {
                length = str.length();
            }
        }

        for (int i = 0; i < length; i++) {
            if (isSameChar(strs, i)) {
                sb.append(strs[0].charAt(i));
            } else {
                break;
            }
        }

        return sb.toString();
    }

    public static boolean isSameChar(String[] str, int index) {
        char c = str[0].charAt(index);

        for (int i = 1; i < str.length; i++) {
            if (c != str[i].charAt(index)) return false;
        }
        return true;
    }

    public String longestCommonPrefixBestVersion(String[] strs) {
        String res = strs[0];

        for (String s : strs) {
            if (s.indexOf(res) != 0) {
                int i;
                for (i = 0; i <= Math.min(res.length() - 1, s.length() - 1); i++) {
                    if (res.charAt(i) != s.charAt(i))
                        break;
                }
                res = res.substring(0, i);
            }
            if (res.length() == 0)
                return "";
        }
        return res;
    }
}
