// Test/TaskServiceTest.java
package Test;

import Main.Task;
import Main.TaskGestor;
import Main.TaskService;

// Imports de JUnit - estos REQUIEREN el JAR descargado
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

public class TaskServiceTest {
    
    private TaskService service;
    private TaskGestor gestor;
    
    @BeforeEach
    void setUp() {
        gestor = new TaskGestor();
        service = new TaskService(gestor);
    }
    
    @Test
    void testAgregarTarea() {
        // Preparar
        String descripcion = "Estudiar Java";
        
        // Ejecutar
        service.agregarTarea(descripcion);
        
        // Verificar
        ArrayList<Task> tareas = service.listarTareas();
        assertEquals(1, tareas.size());
        assertEquals(descripcion, tareas.get(0).getDescription());
        assertFalse(tareas.get(0).isFinished());
    }
    
    @Test
    void testCompletarTarea() {
        service.agregarTarea("Tarea 1");
        
        boolean resultado = service.completarTarea(0);
        
        assertTrue(resultado);
        assertTrue(service.listarTareas().get(0).isFinished());
    }
    
    @Test
    void testEliminarTarea() {
        service.agregarTarea("Tarea 1");
        service.agregarTarea("Tarea 2");
        
        boolean resultado = service.eliminarTarea(0);
        
        assertTrue(resultado);
        assertEquals(1, service.listarTareas().size());
        assertEquals("Tarea 2", service.listarTareas().get(0).getDescription());
    }
}