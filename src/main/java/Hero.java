import java.util.Scanner;

public class Hero {
    public static void main(String[] args) {
        MessageHandler.sendMessage("Hello! I'm Hero\nWhat can I do for you?");

        List messages = new List();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("bye")) {
                break;
            } else if (input.equalsIgnoreCase("list")) {
                messages.getList();
            } else {
                messages.addToList(input);
            }
        }
        scanner.close();
        MessageHandler.sendMessage("Bye. Hope to see you again soon!");
    }
}
