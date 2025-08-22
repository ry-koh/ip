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
                try {
                    int taskNumber = Integer.parseInt(parts[1]);
                    if (taskNumber >= 1 && taskNumber <= messages.getCount()) {
                        messages.mark(taskNumber);
                    } else {
                        MessageHandler.sendMessage("There is no such task number!");
                    }
                } catch (NumberFormatException e) {
                    MessageHandler.sendMessage("Invalid task number!");
                }
            } else if (input.toLowerCase().startsWith("unmark ")) {
                String[] parts = input.split(" ");
                try {
                    int taskNumber = Integer.parseInt(parts[1]);
                    if (taskNumber >= 1 && taskNumber <= messages.getCount()) {
                        messages.unmark(taskNumber);
                    } else {
                        MessageHandler.sendMessage("There is no such task number!");
                    }
                } catch (NumberFormatException e) {
                    MessageHandler.sendMessage("Invalid task number!");
                }
            } else if (input.toLowerCase().startsWith("delete ")) {
                String[] parts = input.split(" ");
                try {
                    int taskNumber = Integer.parseInt(parts[1]);
                    if (taskNumber >= 1 && taskNumber <= messages.getCount()) {
                        messages.deleteFromList(taskNumber);
                    } else {
                        MessageHandler.sendMessage("There is no such task number!");
                    }
                } catch (NumberFormatException e) {
                    MessageHandler.sendMessage("Invalid task number!");
                }
            } else {
                messages.addToList(input);
            }
        }
        scanner.close();
        MessageHandler.sendMessage("Bye. Hope to see you again soon!");
    }
}
