package Test;

import java.util.ArrayList;
import Main.Task;
import Main.TaskGestor;

public class AgendaTest {
    
    public static void main(String[] args) {
        // Puedes agregar pruebas aquí si lo deseas
        System.out.println("Ejecutando pruebas...");
    }
    
    // Método estático para verificar la última tarea
    public static void verificarUltimaTarea(String descripcionEsperada, TaskGestor gestor) {
        ArrayList<Task> tareas = gestor.getList();
        
        if (!tareas.isEmpty()) {
            Task ultimaTarea = tareas.get(tareas.size() - 1);
            String descripcionObtenida = ultimaTarea.getDescription();
            
            if (descripcionObtenida.equals(descripcionEsperada)) {
                System.out.println("✅ [TEST] Confirmado: '" + descripcionObtenida + "' se guardó correctamente.");
            } else {
                System.out.println("❌ [TEST] Error: Se esperaba '" + descripcionEsperada + "' pero se encontró '" + descripcionObtenida + "'.");
            }
        } else {
            System.out.println("❌ [TEST] Error: La lista está vacía.");
        }
    }
}