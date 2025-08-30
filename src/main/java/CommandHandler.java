public class CommandHandler {
    public static void handleList(List tasks) {
        tasks.getList();
    }

    public static void handleMark(List tasks, String content) {
        int taskNumber = parseAndValidateTaskNumber(content, tasks.getCount());
        if (taskNumber != -1) {
            tasks.mark(taskNumber);
        }
    }

    public static void handleUnmark(List tasks, String content) {
        int taskNumber = parseAndValidateTaskNumber(content, tasks.getCount());
        if (taskNumber != -1) {
            tasks.unmark(taskNumber);
        }
    }

    public static void handleDelete(List tasks, String content) {
        int taskNumber = parseAndValidateTaskNumber(content, tasks.getCount());
        if (taskNumber != -1) {
            tasks.deleteFromList(taskNumber);
        }
    }

    public static void handleAddToList(List tasks, String command, String content) {
        switch (command) {
        case "todo":
            if (content.trim().isEmpty()) {
                MessageHandler.sendMessage("Please enter a task");
                return;
            }
            tasks.addToDoToList(content);
            break;
        case "deadline":
            if (!content.contains("/by")) {
                MessageHandler.sendMessage("Please enter a deadline using '/by'");
                return;
            }
            String[] parts = content.split("/by", 2);
            if (parts.length < 2 || parts[0].trim().isEmpty() || parts[1].trim().isEmpty()) {
                MessageHandler.sendMessage("Invalid deadline format");
                return;
            }
            tasks.addDeadlineToList(parts[0].trim(), parts[1].trim());
            break;
        case "event":
            if (!content.contains("/from") || !content.contains("/to")) {
                MessageHandler.sendMessage("Please enter an event using '/from' and '/to'");
                return;
            }
            String[] parts1 = content.split("/from", 2);
            if (parts1.length < 2 || parts1[0].trim().isEmpty()) {
                MessageHandler.sendMessage("Invalid event format");
                return;
            }
            String[] parts2 = parts1[1].split("/to", 2);
            if (parts2.length < 2 || parts2[0].trim().isEmpty() || parts2[1].trim().isEmpty()) {
                MessageHandler.sendMessage("Invalid event format");
                return;
            }
            tasks.addEventToList(parts1[0].trim(), parts2[0].trim(), parts2[1].trim());
            break;
        }
    }

    // Helper Functions

    /**
     * Parses a task number and validates it.
     *
     * @param input the string to parse
     * @param max   the maximum valid task number
     * @return the parsed task number if valid, or -1 if invalid
     */
    public static int parseAndValidateTaskNumber(String input, int max) {
        int taskNumber;

        try {
            taskNumber = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            MessageHandler.sendMessage("Invalid task number!");
            return -1;
        }

        if (taskNumber < 1 || taskNumber > max) {
            MessageHandler.sendMessage("There is no such task number!");
            return -1;
        }

        return taskNumber;
    }

}
