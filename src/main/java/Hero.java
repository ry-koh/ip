import java.util.Scanner;

public class Hero {
    public static void main(String[] args) {
        MessageHandler.sendMessage("Hello! I'm Hero", "What can I do for you?");

        List messages = new List();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("bye")) {
                break;
            } else if (input.equalsIgnoreCase("list")) {
                messages.getList();
            } else if (input.toLowerCase().startsWith("mark ")) {
                String[] parts = input.split(" ");
                int taskNumber = Integer.parseInt(parts[1]);
                messages.mark(taskNumber);
            } else {
                messages.addToList(input);
            }
        }
        scanner.close();
        MessageHandler.sendMessage("Bye. Hope to see you again soon!");
    }
}
