package commands;

import tasks.TaskList;
import messages.MessageHandler;

public class CommandHandler {
    public static void handleTaskList(TaskList taskList) {
        MessageHandler.sendTaskList(taskList);
    }

    public static void handleMark(TaskList taskList, String content) {
        int taskNumber = parseAndValidateTaskNumber(content, taskList.getCount());
        if (taskNumber != -1) {
            taskList.mark(taskNumber);
        }
    }

    public static void handleUnmark(TaskList taskList, String content) {
        int taskNumber = parseAndValidateTaskNumber(content, taskList.getCount());
        if (taskNumber != -1) {
            taskList.unmark(taskNumber);
        }
    }

    public static void handleDelete(TaskList taskList, String content) {
        int taskNumber = parseAndValidateTaskNumber(content, taskList.getCount());
        if (taskNumber != -1) {
            taskList.deleteFromTaskList(taskNumber);
        }
    }

    public static void handleToDo(TaskList taskList, String description) {
        taskList.addToDoToTaskList(description);
    }

    public static void handleDeadline(TaskList taskList, String description, String by) {
        taskList.addDeadlineToTaskList(description, by);
    }

    public static void handleEvent(TaskList taskList, String description, String from, String to) {
        taskList.addEventToTaskList(description, from, to);
    }

    public static void handleFind(TaskList taskList, String text) {
        taskList.find(text);
    }

    /**
     * Parses a task number and validates it.
     *
     * @param input the string to parse
     * @param max   the maximum valid task number
     * @return the parsed task number if valid, or -1 if invalid
     */
    private static int parseAndValidateTaskNumber(String input, int max) {
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
