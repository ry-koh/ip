package tasks;

public class Task {
    protected final String name;
    protected Boolean isDone;

    public Task(String name) {
        this.name = name;
        this.isDone = false;
    }

    public void setDone(Boolean isDone) {
        this.isDone = isDone;
    }

    public String toSaveString() {
        return "";
    }

    @Override
    public String toString() {
        if (isDone) {
            return "[X] " + name;
        }
        return "[ ] " + name;
    }
}
