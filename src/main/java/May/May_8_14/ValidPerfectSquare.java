package May.May_8_14;

public class ValidPerfectSquare {
    public static boolean isPerfectSquare(int num) {
        return num == sqrt(num);
    }

    private static int sqrt(int num) {
        int a = (int) Math.sqrt(num);
        return pow(a);
    }

    private static int pow(int a) {
        return a*a;
    }

    public static void main(String[] args) {
        System.out.println(isPerfectSquare(16));
        System.out.println(isPerfectSquare(14));
        System.out.println(isPerfectSquare(1));
        System.out.println(isPerfectSquare(3));
        System.out.println(isPerfectSquare(2));
        System.out.println(isPerfectSquare(111));

    }
}
