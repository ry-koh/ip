public class CommandHandler {
    public static void handleTaskList(TaskList tasks) {
        tasks.getTaskList();
    }

    public static void handleMark(TaskList tasks, String content) {
        int taskNumber = parseAndValidateTaskNumber(content, tasks.getCount());
        if (taskNumber != -1) {
            tasks.mark(taskNumber);
        }
    }

    public static void handleUnmark(TaskList tasks, String content) {
        int taskNumber = parseAndValidateTaskNumber(content, tasks.getCount());
        if (taskNumber != -1) {
            tasks.unmark(taskNumber);
        }
    }

    public static void handleDelete(TaskList tasks, String content) {
        int taskNumber = parseAndValidateTaskNumber(content, tasks.getCount());
        if (taskNumber != -1) {
            tasks.deleteFromTaskList(taskNumber);
        }
    }

    public static void handleAddToTaskList(TaskList tasks, String command, String content) {
        switch (command) {
        case "todo":
            handleToDo(tasks, content);
            break;
        case "deadline":
            handleDeadline(tasks, content);
            break;
        case "event":
            handleEvent(tasks, content);
            break;
        }
    }

    private static void handleToDo(TaskList tasks, String content) {
        // Check if task description is empty
        if (content.trim().isEmpty()) {
            MessageHandler.sendMessage("Please enter a task");
            return;
        }

        tasks.addToDoToTaskList(content);
    }

    private static void handleDeadline(TaskList tasks, String content) {
        // Check if content contains "/by"
        if (!content.contains("/by")) {
            MessageHandler.sendMessage("Please enter a deadline using '/by'");
            return;
        }

        // Split the content into task and deadline
        String[] parts = content.split("/by", 2);

        // Check if both task and deadline are present and non-empty
        if (parts.length < 2 || parts[0].trim().isEmpty() || parts[1].trim().isEmpty()) {
            MessageHandler.sendMessage("Invalid deadline format");
            return;
        }

        tasks.addDeadlineToTaskList(parts[0].trim(), parts[1].trim());
    }

    private static void handleEvent(TaskList tasks, String content) {
        // Check if content contains "/from" and "/by"
        if (!content.contains("/from") || !content.contains("/to")) {
            MessageHandler.sendMessage("Please enter an event using '/from' and '/to'");
            return;
        }

        // Split the content into task and time range
        String[] parts1 = content.split("/from", 2);

        // Check if task and time range are present
        if (parts1.length < 2 || parts1[0].trim().isEmpty() || parts1[1].trim().isEmpty()) {
            MessageHandler.sendMessage("Invalid event format");
            return;
        }

        // Split the time range into start and end
        String[] parts2 = parts1[1].split("/to", 2);

        // Check if both start and end are present and non-empty
        if (parts2.length < 2 || parts2[0].trim().isEmpty() || parts2[1].trim().isEmpty()) {
            MessageHandler.sendMessage("Invalid event format");
            return;
        }

        tasks.addEventToTaskList(parts1[0].trim(), parts2[0].trim(), parts2[1].trim());
    }

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
