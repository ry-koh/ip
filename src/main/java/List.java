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

    public int getCount() {
        return count;
    }

    public void addToList(String message) {
        Task newTask = new Task(message);
        list[count] = newTask;
        count++;
        MessageHandler.sendMessage("Added Task: " + message);
    }

    public void mark(int taskNumber) {
        list[taskNumber - 1].setDone(true);
        MessageHandler.sendMessage("Nice! I've marked this task as done:", "[X] " + list[taskNumber - 1].getName());
        return;
    }

    public void unmark(int taskNumber) {
        list[taskNumber - 1].setDone(false);
        MessageHandler.sendMessage("OK, I've marked this task as not done yet:", "[ ] " + list[taskNumber - 1].getName());
        return;
    }

    public void deleteFromList(int taskNumber) {
        String deletedTask = list[taskNumber-1].getName();
        for (int i = taskNumber - 1; i < count; i++) {
            list[i] = list[i + 1];
        }
        count--;
        MessageHandler.sendMessage("Deleted Task: " + deletedTask);
    }
}
