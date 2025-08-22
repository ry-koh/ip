public class MessageHandler {
    private static final String LINE = "____________________________________________________________";

    public static void sendMessage(String message) {
        System.out.println(LINE);
        System.out.println(message);
        System.out.println(LINE);
    }

    public static void sendList(int count, String[] messages) {
        System.out.println(LINE);
        for (int i = 0; i < count; i++) {
            System.out.println((i+1) + ". " + messages[i]);
        }
        System.out.println(LINE);
    }
}
