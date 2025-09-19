package tasks;

import java.util.ArrayList;

import messages.MessageHandler;

public class TaskList {

    private final ArrayList<Task> taskList;

    public TaskList() {
        taskList = new ArrayList<>();
    }

    public TaskList(ArrayList<Task> taskList) {
        this.taskList = taskList;
    }

    public Task getTask(int index) {
        return taskList.get(index);
    }

    public int getCount() {
        return taskList.size();
    }

    public void addToDoToTaskList(String task) {
        ToDo newTask = new ToDo(task);
        taskList.add(newTask);
        MessageHandler.sendAddTaskMessage(newTask, getCount());
    }

    public void addDeadlineToTaskList(String task, String deadline) {
        Deadline newTask = new Deadline(task, deadline);
        taskList.add(newTask);
        MessageHandler.sendAddTaskMessage(newTask, getCount());
    }

    public void addEventToTaskList(String task, String start, String end) {
        Event newTask = new Event(task, start, end);
        taskList.add(newTask);
        MessageHandler.sendAddTaskMessage(newTask, getCount());
    }

    public void deleteFromTaskList(int taskNumber) {
        Task deletedTask = taskList.get(taskNumber - 1);
        taskList.remove(taskNumber - 1);
        MessageHandler.sendDeleteTaskMessage(deletedTask, getCount());
    }

    public void mark(int taskNumber) {
        taskList.get(taskNumber - 1).setDone(true);
        MessageHandler.sendMarkMessage(taskList.get(taskNumber - 1));
    }

    public void unmark(int taskNumber) {
        taskList.get(taskNumber - 1).setDone(false);
        MessageHandler.sendUnmarkMessage(taskList.get(taskNumber - 1));
    }

    public void find(String text) {
        ArrayList<Task> findList = new ArrayList<>();
        for (Task task : taskList) {
            if (task.getName().toLowerCase().contains(text.toLowerCase())) {
                findList.add(task);
            }
        }
        if (!findList.isEmpty()) {
            MessageHandler.sendFindList(findList);
        } else {
            MessageHandler.sendMessage("No such task!");
        }
    }
}
