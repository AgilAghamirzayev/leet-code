package algorithms.easy;

public class PalindromeNumber {
    public static void main(String[] args) {
        System.out.println(isPalindromeA(12321));
        System.out.println(isPalindromeB(12321));
        System.out.println(isPalindromeC(12321));
    }

    public static boolean isPalindromeA(int x) {
        int oldNum = x;
        int newNum = 0;

        while (oldNum > 0) {
            newNum = (newNum * 10) + oldNum % 10;
            oldNum = (oldNum - oldNum % 10) / 10;
        }

        return x == newNum;
    }

    public static boolean isPalindromeB(int x) {
        String check = String.valueOf(x);
        final int length = check.length();
        for (int i = 0; i < length; i++) {
            if (check.charAt(i) != check.charAt(length - i - 1)) return false;
        }
        return true;
    }

    public static boolean isPalindromeC(int x) {
        StringBuilder stringBuffer = new StringBuilder();
        return String.valueOf(x).equals(stringBuffer.append(x).reverse().toString());
    }
}
