package ui;

import tasks.Task;

public class MessageHandler {
    private static final String LINE = "____________________________________________________________";

    public static void sendMessage(String... messages) {
        System.out.println(LINE);
        for (String message : messages) {
            System.out.println(message);
        }
        System.out.println(LINE);
    }

    public static void sendTaskList(int count, Task[] taskList) {
        if (count == 0) {
            sendMessage("Task list is empty!");
            return;
        }
        System.out.println(LINE);
        System.out.println("Here are the tasks in your task list:");
        for (int i = 0; i < count; i++) {
            System.out.println((i+1) + ". " + taskList[i].toString());
        }
        System.out.println(LINE);
    }

    public static void sendAddTaskMessage(Task task, int count) {
        System.out.println(LINE);
        System.out.println("Got it. I've added this task:");
        System.out.println(task.toString());
        if (count == 1) {
            System.out.println("Now you have 1 task in the task list.");
        } else {
            System.out.println("Now you have " + count + " tasks in the task list.");
        }
        System.out.println(LINE);
    }

    public static void sendDeleteTaskMessage(Task task, int count) {
        System.out.println(LINE);
        System.out.println("Got it. I've deleted this task:");
        System.out.println(task.toString());
        if (count == 1) {
            System.out.println("Now you have 1 task in the task list.");
        } else {
            System.out.println("Now you have " + count + " tasks in the task list.");
        }
        System.out.println(LINE);
    }

    public static void sendMarkMessage(Task task) {
        System.out.println(LINE);
        System.out.println("Nice! I've marked this task as done:");
        System.out.println(task.toString());
        System.out.println(LINE);
    }

    public static void sendUnmarkMessage(Task task) {
        System.out.println(LINE);
        System.out.println("OK, I've marked this task as not done yet:");
        System.out.println(task.toString());
        System.out.println(LINE);
    }
}
