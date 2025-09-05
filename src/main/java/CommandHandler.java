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

    public static void handleToDo(TaskList tasks, String description) {
        tasks.addToDoToTaskList(description);
    }

    public static void handleDeadline(TaskList tasks, String description, String by) {
        tasks.addDeadlineToTaskList(description, by);
    }

    public static void handleEvent(TaskList tasks, String description, String from, String to) {
        tasks.addEventToTaskList(description, from, to);
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
