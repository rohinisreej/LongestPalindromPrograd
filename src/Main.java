import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        System.out.println(longest_palindrome(input));
    }

    static String longest_palindrome(String input) {
        int start = 0;
        int end = 0;

        for (int i = 0; i < input.length(); i++) {
            int left_len = len_finder(input, i, i);
            int right_len = len_finder(input, i, i + 1);
            int len = Math.max(left_len, right_len);

            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return input.substring(start, end + 1);
    }
    static int len_finder(String input, int left, int right) {
        int L = left;
        int R = right;
        while (L >= 0 && R < input.length() && input.charAt(L) == input.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }
}