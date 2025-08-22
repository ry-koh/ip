public class MessageHandler {
    private static final String LINE = "____________________________________________________________";

    public static void sendMessage(String message) {
        System.out.println(LINE);
        System.out.println(message);
        System.out.println(LINE);
    }

    public static void sendList(int count, Task[] taskList) {
        System.out.println(LINE);
        System.out.println("Here are the tasks in your list:");
        for (int i = 0; i < count; i++) {
            if (taskList[i].getDone()) {
                System.out.println((i + 1) + ".[X] " + taskList[i].getName());
            } else {
                System.out.println((i + 1) + ".[ ] " + taskList[i].getName());
            }
        }
        System.out.println(LINE);
    }
}
