# Gestión de Tareas - Agenda (CI/CD con GitHub Actions)
Este proyecto es una aplicación de consola desarrollada en Java para la gestión de tareas pendientes. Está diseñado bajo principios de programación orientada a objetos y cuenta con un flujo de trabajo automatizado para garantizar la integridad del código mediante Integración Continua (CI).

## Características
Operaciones CRUD: Permite añadir, listar, completar y eliminar tareas.
Persistencia de Datos: Las tareas se guardan automáticamente en un archivo local (tareas.txt) para que la información no se pierda al cerrar el programa.
Capa de Servicio: Implementa un TaskService para separar la lógica de negocio de la gestión de datos, facilitando las pruebas unitarias.
Pruebas Automatizadas: Incluye tests unitarios con JUnit 5 para verificar que las funciones principales trabajen correctamente.
Integración Continua: Configurado con GitHub Actions para compilar y testear el código automáticamente en cada actualización.

## Estructura del Proyecto

<img width="887" height="328" alt="Captura de pantalla 2026-03-09 231847" src="https://github.com/user-attachments/assets/4d4eb70e-9291-4045-8af6-f08d9661c6d4" />

## Automatización (GitHub Actions)
El archivo agenda-automation.yml asegura que el proyecto cumpla con los estándares de calidad antes de cada integración:

Entorno: Configura un corredor con Ubuntu y el JDK 17.
Variables: Utiliza la variable de entorno USER_NAME para personalizar los registros de ejecución.
Compilación: Compila todas las clases incluyendo las bibliotecas de JUnit ubicadas en /lib.
Pruebas: Ejecuta automáticamente los tests unitarios. Si alguna prueba falla, el flujo de trabajo se detendrá y notificará el error.

## Instalación y Uso
Prerrequisitos: Java JDK 17 o superior instalado.

## Ejecución Local
Clona el repositorio.

```bash
javac -d bin Main/*.java
```

Ejecuta la aplicación:

```bash
java -cp bin Main.Main
```

## Ejecutar Pruebas Manualmente
Para ejecutar los tests de JUnit desde la terminal:

```bash
java -jar lib/junit-platform-console-standalone.jar --class-path bin --scan-class-path
```

## Nota
El proyecto utiliza un sistema de persistencia basado en archivos de texto, donde cada tarea se almacena con su descripción y estado de finalización. El archivo .gitignore está configurado para excluir archivos temporales de IDEs y el archivo de datos local para mantener el repositorio limpio.
