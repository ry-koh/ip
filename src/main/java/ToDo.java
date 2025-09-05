public class ToDo extends Task {

    public ToDo(String task) {
        super(task);
    }

    @Override
    public String toString() {
        if (done) {
            return "[T][X] " + name;
        }
        return "[T][ ] " + name;
    }
}
