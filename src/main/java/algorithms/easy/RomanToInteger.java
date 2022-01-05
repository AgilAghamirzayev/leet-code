package algorithms.easy;

public class RomanToInteger {
    //('I', 'V', 'X', 'L', 'C', 'D', 'M').
    public static void main(String[] args) {
        System.out.println(romanToInt("III"));
        System.out.println(romanToInt("LVIII"));
        System.out.println(romanToInt("MCMXCIV"));

        System.out.println(romanToIntBestVersion("III"));
        System.out.println(romanToIntBestVersion("LVIII"));
        System.out.println(romanToIntBestVersion("MCMXCIV"));
    }

    public static int romanToInt(String s) {
        char[] stringArray = s.toCharArray();
        final int length = s.length();
        int intValue = 0;

        for (int i = 0; i < length; i++) {
            final char currChar = stringArray[i];
            if (i != length - 1) {
                final char nextChar = stringArray[i + 1];
                if (intValue(currChar) < intValue(nextChar)) {
                    intValue += (intValue(nextChar) - intValue(currChar));
                    i++;
                    continue;
                }
            }
            intValue += intValue(currChar);
        }

        return intValue;
    }

    public static int romanToIntBestVersion(String s) {
        int result, prev = 0, sum = 0;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            result = intValue(s.charAt(i));

            if (result > prev) {
                sum = sum - prev + result - prev;
            } else {
                sum = sum + result;
            }
            prev = result;
        }
        return sum;
    }

    public static int intValue(char c) {
        return switch (c) {
            case 'I' -> 1;
            case 'V' -> 5;
            case 'X' -> 10;
            case 'L' -> 50;
            case 'C' -> 100;
            case 'D' -> 500;
            case 'M' -> 1000;
            default -> 0;
        };
    }



}
