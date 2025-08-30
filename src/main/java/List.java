public class List {

    private Task[] list;
    private int count;

    private final int MAX_LIST_LENGTH = 100;

    public List() {
        list = new Task[MAX_LIST_LENGTH];
        count = 0;
    }

    public void getList() {
        MessageHandler.sendList(count, list);
    }

    public int getCount() {
        return count;
    }

    public void addToDoToList(String task) {
        ToDo newTask = new ToDo(task);
        list[count] = newTask;
        count++;
        MessageHandler.sendAddTaskMessage(newTask, count);
    }

    public void addDeadlineToList(String task, String deadline) {
        Deadline newTask = new Deadline(task, deadline);
        list[count] = newTask;
        count++;
        MessageHandler.sendAddTaskMessage(newTask, count);
    }

    public void addEventToList(String task, String start, String end) {
        Event newTask = new Event(task, start, end);
        list[count] = newTask;
        count++;
        MessageHandler.sendAddTaskMessage(newTask, count);
    }

    public void deleteFromList(int taskNumber) {
        Task deletedTask = list[taskNumber - 1];
        for (int i = taskNumber - 1; i < count - 1; i++) {
            list[i] = list[i + 1];
        }
        list[count - 1] = null;
        count--;
        MessageHandler.sendDeleteTaskMessage(deletedTask, count);
    }

    public void mark(int taskNumber) {
        list[taskNumber - 1].setDone(true);
        MessageHandler.sendMarkMessage(list[taskNumber - 1]);
    }

    public void unmark(int taskNumber) {
        list[taskNumber - 1].setDone(false);
        MessageHandler.sendUnmarkMessage(list[taskNumber - 1]);
    }
}
