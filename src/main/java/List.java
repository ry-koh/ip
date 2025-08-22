public class List {
    private String[] list;
    private int count;

    public List() {
        list = new String[100];
        count = 0;
    }

    public void getList() {
        MessageHandler.sendList(count, list);
    }

    public void addToList(String message) {
        list[count] = message;
        count++;
        MessageHandler.sendMessage("added: " + message);
    }
}
