package tasks;

public class Task {
    protected final String name;
    protected Boolean done;

    public Task(String name) {
        this.name = name;
        this.done = false;
    }

    public void setDone(Boolean done) {
        this.done = done;
    }

    @Override
    public String toString() {
        if (done) {
            return "[X] " + name;
        }
        return "[ ] " + name;
    }
}
