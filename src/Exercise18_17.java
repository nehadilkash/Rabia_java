import java.util.Scanner;

public class Exercise18_17 {

    public static void main(String[] args) {
        System.out.println("enter string");
        Scanner scanner = new Scanner(System.in);
        char[] line = scanner.nextLine().toCharArray();
        System.out.println("enter character to be searched");
        char c = scanner.next().charAt(0);

        System.out.println(count(line, c));
    }

    public static int count(char[] chars, char ch) {
        return count(chars, ch, chars.length - 1);
    }

    public static int count(char[] chars, char ch, int high) {
        if (high >= 0) {
            if (chars[high] == ch) {
                return 1 + count(chars, ch, high - 1);
            } else {
                return count(chars, ch, high - 1);
            }
        } else {
            return 0;
        }
    }
}
