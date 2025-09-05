import java.util.Scanner;

public class Hero {
    public static void main(String[] args) {
        sendWelcomeMessage();

        TaskList tasks = new TaskList();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String input = readInput(scanner);
            try {
                String[] parsedInput = Parser.parseInput(input);

                if (parsedInput[0].equals("bye")) {
                    break;
                }

                executeCommand(tasks, parsedInput);

            } catch (HeroException e) {
                MessageHandler.sendMessage(e.getMessage());
            }
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

    private static void executeCommand(TaskList tasks, String[] parsedInput) {
        switch (parsedInput[0]) {
        case "list":
            CommandHandler.handleTaskList(tasks);
            break;
        case "mark":
            CommandHandler.handleMark(tasks, parsedInput[1]);
            break;
        case "unmark":
            CommandHandler.handleUnmark(tasks, parsedInput[1]);
            break;
        case "delete":
            CommandHandler.handleDelete(tasks, parsedInput[1]);
            break;
        case "todo":
            CommandHandler.handleToDo(tasks, parsedInput[1]);
            break;
        case "deadline":
            CommandHandler.handleDeadline(tasks, parsedInput[1], parsedInput[2]);
            break;
        case "event":
            CommandHandler.handleEvent(tasks, parsedInput[1], parsedInput[2], parsedInput[3]);
            break;
        }
    }
}