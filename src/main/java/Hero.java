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
                int taskNumber = parseAndValidateTaskNumber(input, messages.getCount());
                if (taskNumber != -1) {
                    messages.mark(taskNumber);
                }
            } else if (input.toLowerCase().startsWith("unmark ")) {
                int taskNumber = parseAndValidateTaskNumber(input, messages.getCount());
                if (taskNumber != -1) {
                    messages.unmark(taskNumber);
                }
            } else if (input.toLowerCase().startsWith("delete ")) {
                int taskNumber = parseAndValidateTaskNumber(input, messages.getCount());
                if (taskNumber != -1) {
                    messages.deleteFromList(taskNumber);
                }
            } else {
                messages.addToList(input);
            }
        }
        scanner.close();
        MessageHandler.sendMessage("Bye. Hope to see you again soon!");
    }

    private static int parseAndValidateTaskNumber(String input, int max) {
        String[] parts = input.split(" ");

        if (parts.length < 2) {
            MessageHandler.sendMessage("Please provide a task number!");
            return -1;
        }

        try {
            int taskNumber = Integer.parseInt(parts[1]);
            if (taskNumber >= 1 && taskNumber <= max) {
                return taskNumber;
            } else {
                MessageHandler.sendMessage("There is no such task number!");
            }
        } catch (NumberFormatException e) {
            MessageHandler.sendMessage("Invalid task number!");
        }
        return -1;
    }
}
