import java.util.Scanner;

public class Hero {
    private static final String LINE = "____________________________________________________________";

    public static void main(String[] args) {
        System.out.println(LINE);
        System.out.println("Hello! I'm Hero");
        System.out.println("What can I do for you?");
        System.out.println(LINE);

        String[] strings = new String[100];
        int count = 0;
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("bye")) {
                break;
            } else if (input.equalsIgnoreCase("list")) {
                for (int i = 0; i < count; i++) {
                    System.out.println((i + 1) + ". " + strings[i]);
                }
            } else {
                strings[count] = input;
                System.out.println("added: " + input);
                count++;
            }
        }
        scanner.close();
        System.out.println(LINE);
        System.out.println("Bye. Hope to see you again soon!");
        System.out.println(LINE);
    }
}
