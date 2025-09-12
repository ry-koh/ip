package tasks;

import java.util.ArrayList;

import messages.MessageHandler;

public class TaskList {

    private Task[] taskList;
    private int count;

    static final int MAX_TASKLIST_LENGTH = 100;

    public TaskList() {
        taskList = new Task[MAX_TASKLIST_LENGTH];
        count = 0;
    }

    public TaskList(ArrayList<Task> tasks) {
        this.taskList = new Task[MAX_TASKLIST_LENGTH];
        this.count = 0;
        for (Task task : tasks) {
            addTask(task);
        }
    }

    public void getTaskList() {
        MessageHandler.sendTaskList(count, taskList);
    }

    public int getCount() {
        return count;
    }

    public void addToDoToTaskList(String task) {
        ToDo newTask = new ToDo(task);
        taskList[count] = newTask;
        count++;
        MessageHandler.sendAddTaskMessage(newTask, count);
    }

    public void addDeadlineToTaskList(String task, String deadline) {
        Deadline newTask = new Deadline(task, deadline);
        taskList[count] = newTask;
        count++;
        MessageHandler.sendAddTaskMessage(newTask, count);
    }

    public void addEventToTaskList(String task, String start, String end) {
        Event newTask = new Event(task, start, end);
        taskList[count] = newTask;
        count++;
        MessageHandler.sendAddTaskMessage(newTask, count);
    }

    public void deleteFromTaskList(int taskNumber) {
        Task deletedTask = taskList[taskNumber - 1];
        for (int i = taskNumber - 1; i < count - 1; i++) {
            taskList[i] = taskList[i + 1];
        }
        taskList[count - 1] = null;
        count--;
        MessageHandler.sendDeleteTaskMessage(deletedTask, count);
    }

    public void mark(int taskNumber) {
        taskList[taskNumber - 1].setDone(true);
        MessageHandler.sendMarkMessage(taskList[taskNumber - 1]);
    }

    public void unmark(int taskNumber) {
        taskList[taskNumber - 1].setDone(false);
        MessageHandler.sendUnmarkMessage(taskList[taskNumber - 1]);
    }

    public Task getTaskWithIndex(int index) {
        return taskList[index];
    }

    private void addTask(Task task) {
        if (count < MAX_TASKLIST_LENGTH) {
            taskList[count] = task;
            count++;
        } else {
            MessageHandler.sendMessage("Task list is full!");
        }
    }
}
