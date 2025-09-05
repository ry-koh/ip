import java.util.Scanner;

public class Hero {
    public static void main(String[] args) {
        sendWelcomeMessage();

        TaskList tasks = new TaskList();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String input = readInput(scanner);
            if (input.isEmpty()) {
                continue;
            }

            String[] parts = input.split(" ", 2);
            String command = parts[0].toLowerCase();
            String content = parts.length > 1 ? parts[1] : "";

            if (command.equals("bye")) {
                break;
            }

            executeCommand(tasks, command, content);
        }
        scanner.close();
        sendExitMessage();
    }

    private static void sendWelcomeMessage() {
        MessageHandler.sendMessage("Hello! I'm Hero", "What can I do for you?");
    }

    private static void sendExitMessage() {
        MessageHandler.sendMessage("Bye. Hope to see you again soon!");
    }

    private static String readInput(Scanner scanner) {
        if (!scanner.hasNextLine()) {
            return "";
        }
        return scanner.nextLine().trim();
    }

    private static void executeCommand(TaskList tasks, String command, String content) {
        switch (command) {
        case "list":
            CommandHandler.handleTaskList(tasks);
            break;
        case "mark":
            CommandHandler.handleMark(tasks, content);
            break;
        case "unmark":
            CommandHandler.handleUnmark(tasks, content);
            break;
        case "delete":
            CommandHandler.handleDelete(tasks, content);
            break;
        case "todo":
        case "deadline":
        case "event":
            CommandHandler.handleAddToTaskList(tasks, command, content);
            break;
        default:
            MessageHandler.sendMessage("Unknown command");
            break;
        }
    }
}