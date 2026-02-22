public class Task {
    private String description;
    private boolean finished;

    public Task(String description) {
        this.description = description;
        this.finished = false; 
    }

    public String getDescription() { return description; }
    public boolean isFinished() { return finished; }
    public void setFinished(boolean status) { this.finished = status; }

    @Override
    public String toString() {
        String statusLabel = finished ? "Completado" : "Incompleto";
        String icon = finished ? "[X]" : "[ ]";
        return String.format("%-20s %s (%s)", description, icon, statusLabel);
    }
}