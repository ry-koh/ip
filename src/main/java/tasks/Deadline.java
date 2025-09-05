package tasks;

public class Deadline extends Task {
    private final String deadline;

    public Deadline(String task, String deadline) {
        super(task);
        this.deadline = deadline;
    }

    @Override
    public String toString() {
        if (done) {
            return "[D][X] " + name + " (by: " + deadline + ")";
        }
        return "[D][ ] " + name + " (by: " + deadline + ")";
    }
}
