// Test/AgendaTest.java
package Test;

import Main.Task;
import Main.TaskGestor;
import Main.TaskService;  // Import necesario
import java.util.ArrayList;

public class AgendaTest {
    
    // Versión que acepta TaskService (la que usa Main)
    public static void verificarUltimaTarea(String descripcionEsperada, TaskService service) {
        Task ultimaTarea = service.obtenerUltimaTarea();
        
        if (ultimaTarea != null) {
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
    
    // Versión original que acepta TaskGestor (para compatibilidad)
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
    
    public static void main(String[] args) {
        System.out.println("Test Agenda - Versión compatible con TaskService y TaskGestor");
    }
}