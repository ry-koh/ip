public class Task {
    private String name;
    private Boolean done;

    public Task(String name) {
        this.name = name;
        this.done = false;
    }

    public String getName() {
        return name;
    }

    public Boolean getDone() {
        return done;
    }
}
