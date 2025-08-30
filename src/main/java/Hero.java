import java.util.Scanner;

public class Hero {
    public static void main(String[] args) {
        MessageHandler.sendMessage("Hello! I'm Hero", "What can I do for you?");

        List tasks = new List();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String input = scanner.nextLine();

            // Extract command
            String[] parts = input.split(" ", 2);

            // Convert command to lower case
            String command = parts[0].toLowerCase();

            // End program command
            if (command.equals("bye")) {
                break;
            }

            switch (command) {
            case "list":
                CommandHandler.handleList(tasks);
                break;
            case "mark":
                CommandHandler.handleMark(tasks, parts[1]);
                break;
            case "unmark":
                CommandHandler.handleUnmark(tasks, parts[1]);
                break;
            case "delete":
                CommandHandler.handleDelete(tasks, parts[1]);
                break;
            case "todo":
            case "deadline":
            case "event":
                CommandHandler.handleAddToList(tasks, parts[0], parts[1]);
                break;
            default:
                MessageHandler.sendMessage("Unknown command");
                break;
            }
        }
        scanner.close();
        MessageHandler.sendMessage("Bye. Hope to see you again soon!");
    }
}
