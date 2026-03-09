// Main/Main.java
package Main;

import java.util.Scanner;
import Test.AgendaTest;

public class Main {
    private Scanner input;
    private TaskService taskService;
    private String ultimaEntrada;
    
    public Main() {
        this.input = new Scanner(System.in);
        this.taskService = new TaskService();
        this.ultimaEntrada = "";
    }
    
    // Este es el método que faltaba - ¡aquí está la lógica principal!
    public void ejecutar() {
        int option = 0;
        do {
            mostrarMenu();
            option = leerOpcion();
            procesarOpcion(option);
        } while (option != 6);
        input.close();
    }
    
    private void mostrarMenu() {
        System.out.println("\n-- GESTOR DE TAREAS --");
        System.out.println("1. Agregar tarea");
        System.out.println("2. Listar tareas");
        System.out.println("3. Marcar como completada");
        System.out.println("4. Eliminar tarea");
        System.out.println("5. Auto-diagnóstico");
        System.out.println("6. Salir");
        System.out.print("> ");
    }
    
    private int leerOpcion() {
        if (input.hasNextInt()) {
            return input.nextInt();
        }
        input.nextLine();
        return 0;
    }
    
    private void procesarOpcion(int option) {
        input.nextLine(); // Consumir salto de línea
        
        switch(option) {
            case 1:
                agregarTarea();
                break;
            case 2:
                listarTareas();
                break;
            case 3:
                completarTarea();
                break;
            case 4:
                eliminarTarea();
                break;
            case 5:
                ejecutarAutodiagnostico();
                break;
            case 6:
                System.out.println("Saliendo...");
                break;
            default:
                System.out.println("Opción inválida");
        }
    }
    
    private void agregarTarea() {
        System.out.print("Descripción de la tarea: ");
        ultimaEntrada = input.nextLine();
        taskService.agregarTarea(ultimaEntrada);
        System.out.println("¡Tarea guardada!");
    }
    
    private void listarTareas() {
        var tareas = taskService.listarTareas();
        if (tareas.isEmpty()) {
            System.out.println("No hay tareas.");
        } else {
            System.out.println("\n--- TUS TAREAS ---");
            for(int i = 0; i < tareas.size(); i++) {
                System.out.println((i+1) + ". " + tareas.get(i));
            }
        }
    }
    
    private void completarTarea() {
        System.out.print("Número de tarea a completar: ");
        int index = input.nextInt() - 1;
        if (taskService.completarTarea(index)) {
            System.out.println("¡Tarea completada!");
        } else {
            System.out.println("Número inválido.");
        }
    }
    
    private void eliminarTarea() {
        System.out.print("Número de tarea a eliminar: ");
        int index = input.nextInt() - 1;
        if (taskService.eliminarTarea(index)) {
            System.out.println("Tarea eliminada.");
        } else {
            System.out.println("Número inválido.");
        }
    }
    
    private void ejecutarAutodiagnostico() {
        if (ultimaEntrada.isEmpty()) {
            System.out.println("No se ha añadido ninguna tarea en esta sesión para validar.");
        } else {
            System.out.println("\n--- VALIDANDO ÚLTIMA ENTRADA REAL ---");
            // Pasamos el service, no el gestor
            AgendaTest.verificarUltimaTarea(ultimaEntrada, taskService);
        }
    }
    
    public static void main(String[] args) {
        Main app = new Main();
        app.ejecutar();  // ¡Ahora sí existe el método!
    }
}