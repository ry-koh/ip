package tasks;

public class Event extends Task {
    private final String start;
    private final String end;

    public Event(String task, String start, String end) {
        super(task);
        this.start = start;
        this.end = end;
    }

    @Override
    public String toSaveString() {
        if (done) {
            return "E|1|" + name + "|" + start + "|" + end;
        }
        return "E|0|" + name + "|" + start + "|" + end;
    }

    @Override
    public String toString() {
        if (done) {
            return "[E][X] " + name + " (from: " + start + " | to: " + end + ")";
        }
        return "[E][ ] " + name + " (from: " + start + " | to: " + end + ")";
    }
}
