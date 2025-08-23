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
            }

            String[] parts = input.split(" ", 2);
            String command = parts[0].toLowerCase();
            int taskNumber;

            switch (command) {
            case "list":
                messages.getList();
                break;
            case "mark":
                taskNumber = parseAndValidateTaskNumber(parts, messages.getCount());
                if (taskNumber != -1) {
                    messages.mark(taskNumber);
                }
                break;
            case "unmark":
                taskNumber = parseAndValidateTaskNumber(parts, messages.getCount());
                if (taskNumber != -1) {
                    messages.unmark(taskNumber);
                }
                break;
            case "delete":
                taskNumber = parseAndValidateTaskNumber(parts, messages.getCount());
                if (taskNumber != -1) {
                    messages.deleteFromList(taskNumber);
                }
                break;
            default:
                messages.addToList(input);
            }
        }
        scanner.close();
        MessageHandler.sendMessage("Bye. Hope to see you again soon!");
    }

    private static int parseAndValidateTaskNumber(String[] parts, int max) {
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
