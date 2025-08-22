public class List {
    private Task[] list;
    private int count;

    public List() {
        list = new Task[100];
        count = 0;
    }

    public void getList() {
        MessageHandler.sendList(count, list);
    }

    public void addToList(String message) {
        Task newTask = new Task(message);
        list[count] = newTask;
        count++;
        MessageHandler.sendMessage("Added Task: " + message);
    }
}
