package tasks;

public class ToDo extends Task {

    public ToDo(String task) {
        super(task);
    }

    @Override
    public String toSaveString() {
        if (isDone) {
            return "T|1|" + name;
        }
        return "T|0|" + name;
    }

    @Override
    public String toString() {
        if (isDone) {
            return "[T][X] " + name;
        }
        return "[T][ ] " + name;
    }
}
