package tasks;

public class Deadline extends Task {
    private final String deadline;

    public Deadline(String task, String deadline) {
        super(task);
        this.deadline = deadline;
    }

    @Override
    public String toSaveString() {
        if (isDone) {
            return "D|1|" + name + "|" + deadline;
        }
        return "D|0|" + name + "|" + deadline;
    }

    @Override
    public String toString() {
        if (isDone) {
            return "[D][X] " + name + " (by: " + deadline + ")";
        }
        return "[D][ ] " + name + " (by: " + deadline + ")";
    }
}
