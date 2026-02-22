import java.util.ArrayList;
import java.io.*;

public class TaskGestor {
    private ArrayList<Task> list = new ArrayList<>();
    private final String FILE_NAME = "tareas.txt";

    public TaskGestor() {
        loadFromFile();
    }

    public void add(String desc) {
        list.add(new Task(desc));
    }

    public ArrayList<Task> getList() {
        return list;
    }

    public boolean delete(int index) {
        if (index >= 0 && index < list.size()) {
            list.remove(index);
            return true;
        }
        return false;
    }

    public void saveToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Task task : list) {
                writer.write(task.getDescription() + "|" + task.isFinished());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error al guardar las tareas: " + e.getMessage());
        }
    }

    private void loadFromFile() {
        File file = new File(FILE_NAME);
        if (!file.exists()) return;

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\|");
                if (parts.length == 2) {
                    Task task = new Task(parts[0]);
                    task.setFinished(Boolean.parseBoolean(parts[1]));
                    list.add(task);
                }
            }
        } catch (IOException e) {
            System.out.println("Error al cargar las tareas: " + e.getMessage());
        }
    }
}