package tasks;

/**
 * The base class for all tasks in the Hero application
 * It provides core functionality common to all task types, such as a name and a completion status
 */
public class Task {

    protected final String name;
    protected Boolean isDone;

    /**
     * Constructs a Task with the given name and a default status of not done
     * @param name The name of the task
     */
    public Task(String name) {
        this.name = name;
        this.isDone = false;
    }

    /**
     * Returns the name of the task
     * @return The name of the task as a String
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the completion status of the task
     * @param isDone A boolean indicating if the task is done (true) or not (false)
     */
    public void setDone(Boolean isDone) {
        this.isDone = isDone;
    }

    /**
     * Returns a string representation of the task suitable for saving to a file
     * This method is intended to be overridden by subclasses to provide specific formatting
     * @return An empty string
     */
    public String toSaveString() {
        return "";
    }

    /**
     * Returns a human-readable string representation of the task, showing its completion status
     * @return A formatted string
     */
    @Override
    public String toString() {
        if (isDone) {
            return "[X] " + name;
        }
        return "[ ] " + name;
    }
}
