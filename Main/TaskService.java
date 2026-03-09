// Main/TaskService.java
package Main;

import java.util.ArrayList;

public class TaskService {
    private TaskGestor gestor;
    
    public TaskService() {
        this.gestor = new TaskGestor();
    }
    
    public TaskService(TaskGestor gestor) {
        this.gestor = gestor;
    }
    
    public void agregarTarea(String descripcion) {
        gestor.add(descripcion);
    }
    
    public boolean completarTarea(int indice) {
        return gestor.completeTask(indice);
    }
    
    public boolean eliminarTarea(int indice) {
        return gestor.delete(indice);
    }
    
    public ArrayList<Task> listarTareas() {
        return gestor.getList();
    }
    
    public Task obtenerUltimaTarea() {
        ArrayList<Task> tareas = gestor.getList();
        if (tareas.isEmpty()) {
            return null;
        }
        return tareas.get(tareas.size() - 1);
    }
}