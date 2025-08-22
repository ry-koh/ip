import java.util.Scanner;

public class Hero {
    private static final String LINE = "____________________________________________________________";

    public static void main(String[] args) {
        sendMessage("Hello! I'm Hero\nWhat can I do for you?");

        String[] strings = new String[100];
        int count = 0;
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("bye")) {
                break;
            } else if (input.equalsIgnoreCase("list")) {
                System.out.println(LINE);
                for (int i = 0; i < count; i++) {
                    System.out.println((i + 1) + ". " + strings[i]);
                }
                System.out.println(LINE);
            } else {
                strings[count] = input;
                sendMessage("added: " + input);
                count++;
            }
        }
        scanner.close();
        sendMessage("Bye. Hope to see you again soon!");
    }

    private static void sendMessage(String message) {
        System.out.println(LINE);
        System.out.println(message);
        System.out.println(LINE);
    }
}
