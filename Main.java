import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("-- GESTOR DE TAREAS --\n"); 
        
        TaskGestor gestor = new TaskGestor();
        int option = 0;

        do {
            System.out.println("\nSELECCIONE UNA OPCIÓN: ");
            System.out.println("1. Agregar tarea");
            System.out.println("2. Listar tareas");
            System.out.println("3. Marcar tarea como completada");
            System.out.println("4. Eliminar tarea");
            System.out.println("5. Salir");
            System.out.print("> ");
            
            if (!input.hasNextInt()) {
                input.nextLine();
                continue;
            }
            option = input.nextInt();
            input.nextLine();

            switch(option) {
                case 1 -> {
                    System.out.print("Descripción de la tarea: ");
                    gestor.add(input.nextLine());
                    System.out.println("¡Tarea guardada!");
                }
                case 2 -> {
                    var tasks = gestor.getList();
                    if (tasks.isEmpty()) {
                        System.out.println("No hay tareas.");
                    } else {
                        System.out.println("\n--- TUS TAREAS ---");
                        for(int i=0; i < tasks.size(); i++) 
                            System.out.println((i+1) + ". " + tasks.get(i));
                    }
                }
                case 3 -> {
                    System.out.print("Número de tarea a completar: ");
                    int index = input.nextInt();
                    if (gestor.completeTask(index - 1)) {
                        System.out.println("¡Tarea completada!");
                    } else {
                        System.out.println("Número inválido.");
                    }
                }
                case 4 -> {
                    System.out.print("Número de tarea a eliminar: ");
                    int index = input.nextInt();
                    if (gestor.delete(index - 1)) {
                        System.out.println("Tarea eliminada.");
                    } else {
                        System.out.println("Número inválido.");
                    }
                }
                case 5 -> {
                    gestor.saveToFile();
                    System.out.println("Datos guardados. Saliendo...");
                }
                default -> System.out.println("Opción inválida.");
            }
        } while (option != 5);
        
        input.close();
    }
}