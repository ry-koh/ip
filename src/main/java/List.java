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

    public void mark(int taskNumber) {
        if (taskNumber >= 1 && taskNumber <= count) {
            list[taskNumber - 1].setDone(true);
            MessageHandler.sendMessage("Nice! I've marked this task as done:", "[X] " + list[taskNumber - 1].getName());
            return;
        }
        MessageHandler.sendMessage("There is no such task number!");
    }
}
